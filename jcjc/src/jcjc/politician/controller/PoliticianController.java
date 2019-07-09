package jcjc.politician.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jcjc.politician.biz.PoliticianBiz;
import jcjc.politician.entity.Politician;
import jcjc.user.entity.User;

@Controller("politicianController")
public class PoliticianController {

	@Autowired
	private PoliticianBiz biz;
	
	Logger log = Logger.getLogger(this.getClass());
	
	String pre_log = "";
	String post_log = "";
	String session_id = "";
	
	//all
	@RequestMapping("/politician/all.do")
	public ModelAndView politicianAll() {
		List<Politician> all = biz.selectAllPolitician();
		
		return new ModelAndView("politician/all", "all", all);
	}
	
	// 페이지 이동
	
	@RequestMapping("/politician/type.do")
	public ModelAndView selectType() {
		return new ModelAndView("politician/type");
	}
	
	@RequestMapping("/politician/location.do")
	public ModelAndView selectLocation() {
		return new ModelAndView("politician/location");
	}
	
	@RequestMapping("/politician/matching.do")
	public ModelAndView politicianMatching(HttpSession session) {
		Politician entity = (Politician) session.getAttribute("politician");
		return new ModelAndView("politician/matching");
	}

	// 정치인 이행률 예측 페이지 + log 적재 포함
	
	@RequestMapping("/politician/prediction.do")
	public ModelAndView prediction(@RequestParam("politician_no") int politician_no, HttpSession session) {

//		String pre_log = null;
//		String post_log = null;
		
		User user = (User) session.getAttribute("user");
		Politician politician = biz.findPolitian(politician_no);
		session.setAttribute("politician",  politician);
		
		if(!session_id.equals(session.getId())) {
			session_id = session.getId();
			pre_log = "null";
			post_log = politician.getPolitician_kor_name()+"("+politician.getPolitician_hj_name()+")";
		} else {
			pre_log = post_log;
			post_log = politician.getPolitician_kor_name()+"("+politician.getPolitician_hj_name()+")";
		}
		
		if((!pre_log.equals(post_log)) && (!pre_log.equals("null"))){
			log.info(user.getUser_id()+"|"+session_id+"|"+pre_log+"/"+post_log);
		}
		
		return new ModelAndView("politician/prediction", "politician", politician);
	}
	

	@RequestMapping("/politician/profile.do")
	public ModelAndView profile(HttpSession session) {
		Politician entity = (Politician) session.getAttribute("politician");
		Politician politician = biz.findPolitian(entity.getPolitician_no());
		return new ModelAndView("politician/profile", "politician", politician);
	}

	// 회원 가입 시 호출하는 부분
	
	// [politiciuser_prefer_politician]
	@RequestMapping("/politician/prefer.do")
	public ModelAndView preferPoliticianList() {
		List<Politician> politician = biz.selectAllPolitician();
		return new ModelAndView("/user/preferpolitician", "politician", politician);
	}
	
	// [politiciuser_support_politician]
	@RequestMapping("/politician/support.do")
	public ModelAndView supportPoliticianList() {
		List<Politician> politician = biz.selectAllPolitician();
		return new ModelAndView("/user/supportpolitician", "politician", politician);
	}
	
	
	// [필터링 미구현 상태...]
	@RequestMapping(value = "/politician/search.do", method = RequestMethod.GET)
	public ModelAndView searchPolitician(@RequestParam("findpolitician") String findpolitician) {
		List<Politician> politician = biz.searchPolitician(findpolitician);
		return new ModelAndView("/user/searchpolitician", "politician", politician);
	}
	
}
