package jcjc.user.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jcjc.committee.entitiy.Committee;
import jcjc.user.biz.UserBiz;
import jcjc.user.entity.User;
import jcjc.user.validator.DeleteValidator;
import jcjc.user.validator.JoinValidator;
import jcjc.user.validator.LoginValidator;

@Controller
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserBiz biz;
	
	@Autowired
	LoginValidator login_validator;
	@Autowired
	JoinValidator join_validator;
	@Autowired
	DeleteValidator delete_validator;
	

	
	// [join]
	@RequestMapping(value = "/user/join.do", method=RequestMethod.GET)
	public ModelAndView join() {
		User user = new User();
		return new ModelAndView("user/join", "user", user);
	}
	
	@RequestMapping(value = "/user/join.do", method=RequestMethod.POST)
	public ModelAndView join(@ModelAttribute("user") User user, Errors error) {
		join_validator.validate(user, error);
		
		if(error.hasErrors()) {
			return new ModelAndView("user/join");
		} else {
			int res = biz.insertUser(user);
			if (res > 0) {
				return new ModelAndView("user/joinsuccess", "user", user);
			}
			else
				return null;
		}
	} // join()
	

	
	// [login]
	@RequestMapping(value = "/user/login.do", method = RequestMethod.GET)
	public ModelAndView login() {
		User user = new User();
		return new ModelAndView("user/login", "user", user);
	}
	
	@RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user, Errors error, HttpServletRequest req) {
		login_validator.validate(user, error);
		
		if(error.hasErrors()) { // 유효값 검사에서 에러가 발견될 경우
			return new ModelAndView("user/login");
		} else { // 유효값 검사에서 에러가 발견되지 않았을 경우
			try {
				User user_chk = biz.loginUser(user.getUser_id(), user.getUser_password()); // DB에서 일치하는 값이 있는지 찾아온다.
				if ( (user.getUser_id().trim().equals(user_chk.getUser_id().trim())) && 
						(user.getUser_password().trim().equals(user_chk.getUser_password().trim())) ) {
					// DB에서 가져온 id, pw와 입력값이 일치할 경우
					req.getSession().setAttribute("user", user_chk); // 세션에 사용자 정보를 저장한다.
					return new ModelAndView("../../index", "user", user_chk);
				}
			} catch (Exception e) {
				ModelAndView mav = new ModelAndView("user/fail");
				mav.addObject("user", null);
				mav.addObject("fail_title", "로그인 실패");
				mav.addObject("fail_message", "아이디 혹은 비밀번호가 잘못되었습니다.<br>다시한번 입력해주세요.");
				return mav;
			}
		}
		return null;
	} // login()
	
	
	
	// [logout]
	@RequestMapping("/user/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "../../index";
	}
		
	
	
	// [update]
	@RequestMapping(value = "/user/update.do", method=RequestMethod.GET)
	public ModelAndView update(HttpSession session) {
		User user = (User) session.getAttribute("user"); // 세션에 사용자 정보를 가져온다.
		
		User user_chk = biz.findUser(user.getUser_id()); // DB에서 일치하는 값이 있는지 찾아온다.
		
		if ( (user.getUser_id().trim().equals(user_chk.getUser_id().trim())) && 
			 (user.getUser_password().trim().equals(user_chk.getUser_password().trim())) ) {
			// DB에서 가져온 id, pw와 입력값이 일치할 경우
			return new ModelAndView("user/update", "user_update", user);
		} else {
			return new ModelAndView("user/login");
		}
	}
	
	@RequestMapping(value = "/user/update.do", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("user_update") User user, Errors error, HttpSession session) {
		join_validator.validate(user, error);
		
		if(error.hasErrors()) { // 유효값 검사에서 에러가 발견될 경우
			return new ModelAndView("user/update");
		} else { // 유효값 검사에서 에러가 발견되지 않았을 경우
			int res = biz.updateUser(user);
			if (res > 0) {
				session.setAttribute("user", user);
				return new ModelAndView("user/update", "user", user);
			}
			else return null;
		}
	} // update()
	
	
	
	// [delete]
	@RequestMapping(value = "/user/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(HttpSession session) {
		User user = (User) session.getAttribute("user"); // 세션에 사용자 정보를 가져온다.
		User user_chk = biz.findUser(user.getUser_id()); // DB에서 일치하는 값이 있는지 찾아온다.
		
		if ( (user.getUser_id().trim().equals(user_chk.getUser_id().trim())) && 
			 (user.getUser_password().trim().equals(user_chk.getUser_password().trim())) ) {
			// DB에서 가져온 id, pw와 입력값이 일치할 경우
			return new ModelAndView("user/delete", "user", user);
		} else {
			return new ModelAndView("user/login");
		}
	}

	@RequestMapping(value = "/user/delete.do", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("user") User user, Errors error, HttpSession session) {
		delete_validator.validate(user, error);
		
		if(error.hasErrors()) { // 유효값 검사에서 에러가 발견될 경우
			return new ModelAndView("user/delete");
		} else { // 유효값 검사에서 에러가 발견되지 않았을 경우
			User user_chk = (User) session.getAttribute("user"); // 세션에 저장된 사용자 정보를 가져온다.
			if ( (user.getUser_password().trim().equals(user_chk.getUser_password().trim())) ) {
				// 세션에 저장된 pw와 입력값이 일치할 경우
				biz.deleteUser(user_chk.getUser_id().trim()); // 사용자를 삭제한다.
				session.invalidate();
				return new ModelAndView("user/deletesuccess", "user", user);
			} else {
				ModelAndView mav = new ModelAndView("user/fail");
				mav.addObject("user", null);
				mav.addObject("fail_title", "계정 삭제 실패");
				mav.addObject("fail_message", "비밀번호가 잘못되었습니다.<br>비밀번호를 다시한번 확인해주세요.");
				return mav;
			}
		}
	} // delete()


	
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////

	// [ID 중복확인]
	@RequestMapping(value = "/user/idDuplication.do", produces = "application/text;charset=utf-8")
	@ResponseBody
	public String userIdChk(@RequestParam("user_id") String user_id, HttpSession session) throws Exception {
		List<User> user = biz.selectAllUser();
		for(User user_id_chk : user) {
			if(user_id_chk.getUser_id().equals(user_id)) {
				return user_id + "은 이미 등록되어있습니다."; 
			}
		}
		return user_id + "은 사용할 수 있습니다";
	}
	
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////	
	
	@RequestMapping(value = "/user/findid.do", method = RequestMethod.GET)
	public ModelAndView findId() {
		User user = new User();
		return new ModelAndView("user/findid", "user_find", user);
	}
	
	@RequestMapping(value = "/user/findid.do", method = RequestMethod.POST)
	public ModelAndView findId(@ModelAttribute("user_find") User user) {
		String id_find = biz.findId(user.getUser_name(), user.getUser_email() );
		if(id_find == null) {
			ModelAndView mav = new ModelAndView("user/fail");
			mav.addObject("user", null);
			mav.addObject("fail_title", "아이디 찾기 실패");
			mav.addObject("fail_message", "입력하신 정보에 해당하는 아이디가 없습니다.<br>다시한번 입력해주세요.");
			return mav;
		} else {
			return new ModelAndView("user/findidsuccess", "id_find", id_find);
		}
	}

	@RequestMapping(value = "/user/findpassword.do", method = RequestMethod.GET)
	public ModelAndView findPassword() {
		User user = new User();
		return new ModelAndView("user/findpassword", "user_find", user);
	}
	
	@RequestMapping(value = "/user/findpassword.do", method = RequestMethod.POST)
	public ModelAndView findPassword(@ModelAttribute("user_find") User user) {
		String ps_find = biz.findPassword(user.getUser_id(), user.getUser_name(), user.getUser_email());
		
		if(ps_find == null) {
			ModelAndView mav = new ModelAndView("user/fail");
			mav.addObject("user", null);
			mav.addObject("fail_title", "비밀번호 찾기 실패");
			mav.addObject("fail_message", "입력하신 정보에 해당하는 비밀번호가 없습니다.<br>다시한번 입력해주세요.");
			return mav;
		} else {
			return new ModelAndView("user/findpasswordsuccess", "ps_find", ps_find);
		}
	}
		
	
	/////////////////
	@RequestMapping("/user/interestlist.do")
	public ModelAndView userInterestList() {
		List<Committee> committee_list = biz.selectAllCommittee();
		return new ModelAndView("user/interestlist", "committee_list", committee_list);
		
	}
}
