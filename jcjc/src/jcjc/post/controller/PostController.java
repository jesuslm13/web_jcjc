package jcjc.post.controller;

import java.util.List;

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

import jcjc.commitment.biz.CommitmentBiz;
import jcjc.commitment.entity.Commitment;
import jcjc.commitment.entity.CommitmentEntity;
import jcjc.politician.entity.Politician;
import jcjc.post.biz.PostBiz;
import jcjc.post.entity.Post;
import jcjc.user.entity.User;

@Controller("postController")
public class PostController {
	
	@Autowired
	private PostBiz biz;
	
	@Autowired
	private CommitmentBiz commitmentBiz;
	

	// all
	@RequestMapping("/post/all.do")
	public ModelAndView  all() {
		List<Post> all = biz.selectAllPost();
		return new ModelAndView("post/all", "all", all);
	}

	// list
	@RequestMapping("/post/list.do")
	public ModelAndView  list(@RequestParam("commitment_no") int commitment_no, HttpSession session) {
		session.setAttribute("commitment_no", commitment_no);
		
		List<Post> list = biz.selectListPost(commitment_no);
		
		return new ModelAndView("post/list", "postList", list);
	}
	
	// search
	@RequestMapping("/post/search.do")
	public ModelAndView search() {
		Post entity = biz.searchPost(1, "user_id01");
		return new ModelAndView("post/list","entity",entity);
	}
	
		
	
	// [update]
	@RequestMapping(value = "/post/update.do", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam("post_no") int post_no, HttpSession session) {
		User user = (User) session.getAttribute("user"); // 세션에서 사용자 정보를 가져온다.
		if (user == null)
			return new ModelAndView("post/updateerror");
		System.out.println("수정하려는 사용자 : " + user);
		
		List<Post> post_array = biz.findPost(user.getUser_id()); // DB에서 수정 요청한 사용자가 쓴 글을 모두 가져온다.

		for(Post post : post_array) {
			if ( post.getPost_no() == post_no ) {
				Post post_update = biz.searchPost(post_no, user.getUser_id()); // DB에서 post 객체를 가져온다.
				System.out.println("수정할 게시물 정보 : " + post_update);
				session.setAttribute("post", post);
				return new ModelAndView("post/update", "post", post_update);
			}
		}
		return new ModelAndView("post/updateerror");
	}

	@RequestMapping(value = "/post/update.do", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("post") Post post, Errors error, HttpSession session) {
		System.out.println("업데이트 POST 방식");
		
		// 게시물 날짜 현재로 변경
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(new java.util.Date());
		post.setPost_date(today);

		System.out.println("번호 변경 전 : " + post);
		// 게시물 번호 변경
		Post s_post = (Post) session.getAttribute("post");
		post.setPost_no(s_post.getPost_no());
		
		System.out.println("번호 변경 후 : " + post);
		
		int res = biz.updatePost(post);
		if (res > 0) {
			session.setAttribute("post", post);
			return detail(post.getPost_no(), session);
		}
		else return null;
	} // update()
		
		/*
		@RequestMapping(value = "/board/update.do", method=RequestMethod.POST)
		public ModelAndView update(@ModelAttribute("board") BoardEntity board, Errors error, HttpSession session) {
			
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String today = formatter.format(new java.util.Date());
			board.setBoard_date(today);
			
			int res = biz.updateBoard(board);
			if (res > 0) {
				System.out.println("res : " + res);
				return new ModelAndView("board/list");
			}
			else return null;
		} // update()
		 */
	
	
	// delete
	@RequestMapping(value="/post/delete.do", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("post_no") int post_no, HttpSession session) {
		User user = (User) session.getAttribute("user"); // 세션에서 사용자 정보를 가져온다.
		if (user == null)
			return new ModelAndView("post/deleteerror");
		
		List<Post> post_array = biz.findPost(user.getUser_id()); // DB에서 삭제 요청한 사용자가 쓴 글을 모두 가져온다.
		
		for(Post post : post_array) {
			if (post.getPost_no() == post_no) { 
				int res = biz.deletePost(post.getPost_no()); // DB에서 해당 번호의 게시물 데이터를 삭제
				if (res > 0) {
					Politician entity = (Politician) session.getAttribute("politician");
					List<CommitmentEntity> list = commitmentBiz.selectListCommitmentAddAvg(entity);
					return new ModelAndView("commitment/list", "commitmentList", list);
					//return commitmentController.commitmentList(session);
				}
			}
		}
		return new ModelAndView("post/deleteerror");
	}
	
	
	
	// insert
	@RequestMapping(value = "/post/insert.do", method=RequestMethod.GET)
	public ModelAndView insert(@RequestParam("commitment_no") int commitment_no, HttpSession session) {
		User user = (User) session.getAttribute("user"); // 세션에서 사용자 정보를 가져온다.
		if (user == null)
			return new ModelAndView("post/inserterror");

		Post post = new Post();
		post.setCommitment_no(commitment_no);
		post.setUser_id(user.getUser_id());
		
		return new ModelAndView("post/insert", "post", post);
	}
	
	
	
	@RequestMapping(value = "/post/insert.do", method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("post") Post post, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("post/error");
		} 
		Post post_insert = new Post();
		post_insert.setCommitment_no(post.getCommitment_no());
		post_insert.setUser_id(user.getUser_id());
		post_insert.setPost_title(post.getPost_title());
		post_insert.setPost_score(post.getPost_score());
		post_insert.setPost_content(post.getPost_content());
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(new java.util.Date());
		post_insert.setPost_date(today);
		
		System.out.println("이걸 넣을거야 : " + post_insert);
		
		int res = biz.insertPost(post_insert);
		if(res > 0) {
			return new ModelAndView("post/detail", "post", post_insert);
			//return commitmentController.commitmentList(session);
			//return new ModelAndView("post/list");
		}
		return null;
	}
	
	@RequestMapping("/post/detail.do")
	public ModelAndView detail(@RequestParam("post_no") int post_no, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return new ModelAndView("post/detailerror");
		}
		Post entity = biz.detailPost(post_no);
		return new ModelAndView("post/detail", "post", entity);
	}
	
//	@RequestMapping("/post/avg.do")
//	@ResponseBody
//	public String avgScore(@RequestParam("commitment_no") int commitment_no) {
//		
//		Double avg = biz.avgScorePost(commitment_no);
//		return avg.toString();
//	}
	

	
}
