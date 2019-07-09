package jcjc.reply.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jcjc.reply.biz.ReplyBiz;
import jcjc.reply.entity.Reply;
import jcjc.user.entity.User;

@Controller("replyController")
public class ReplyController {

	@Autowired
	private ReplyBiz biz;
	
	
	// all
	@RequestMapping("/reply/all.do")
	public ModelAndView replyAll() {
		List<Reply> all= biz.selectAllReply();
		return new ModelAndView("reply/list", "all", all);
	}
	
	
	// list
	@RequestMapping("/reply/list.do")
	public ModelAndView replyList(@RequestParam("post_no") int post_no) {
		List<Reply> all= biz.selectListReply(post_no);
		return new ModelAndView("reply/list", "replyList", all);
	}
	
	// insert	
	@RequestMapping(value = "/reply/insert.do", method=RequestMethod.POST)
	public ModelAndView replyInsert(@ModelAttribute("reply") Reply reply, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null)
			return new ModelAndView("reply/error");
		
		reply.setUser_id(user.getUser_id());
		
		// 댓글 날짜 현재로 변경
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(new java.util.Date());
		reply.setReply_date(today);

		int res = biz.insertReply(reply);
		if (res > 0) {
			return new ModelAndView("post/detail");
		}
		return null;
	}
	
	
	
	
	
	
	// content
	@RequestMapping("/reply/content.do")
	public ModelAndView replyContent(@ModelAttribute("reply") Reply reply) {
		return new ModelAndView("reply/content", "reply", reply);
	}
	
	// update
	@RequestMapping(value = "/reply/update.do", method=RequestMethod.GET)
	public ModelAndView replyUpdate(@RequestParam("reply_no") int reply_no, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null)
			return new ModelAndView("reply/error");
		
		List<Reply> reply_array = biz.findReply(user.getUser_id());
		for(Reply reply : reply_array) {
			if (reply.getReply_no() == reply_no) { 
				Reply reply_update = biz.searchReply(reply_no, user.getUser_id());
				return new ModelAndView("reply/update", "reply", reply_update);
			}
		}
		return new ModelAndView("reply/error");
	}
	
	@RequestMapping(value = "/reply/update.do", method=RequestMethod.POST)
	public ModelAndView replyUpdate(@ModelAttribute("reply") Reply reply, Errors error, HttpSession session) {
		
		// 댓글 날짜 현재로 변경
		java.text.SimpleDateFormat formatter=  new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(new java.util.Date());
		reply.setReply_date(today);
		
		int res = biz.updateReply(reply);
		if (res > 0) {
			session.setAttribute("reply", reply);
			return replyList(reply.getPost_no());
		}
		return new ModelAndView("reply/error");
	}
	
	
	
	
	
	
	
	
	// delete
	@RequestMapping(value = "/reply/delete.do", method=RequestMethod.GET)
	public ModelAndView replyDelete(@RequestParam("reply_no") int reply_no, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null)
			return new ModelAndView("reply/error");
		
		List<Reply> reply_array = biz.findReply(user.getUser_id());
		for(Reply reply : reply_array) {
			if (reply.getReply_no() == reply_no) { 
				int res = biz.deleteReply(reply_no); // DB에서 해당 번호의 댓글 데이터를 삭제
				if (res > 0)
					return new ModelAndView("/post/detail");
			}
		}
		return new ModelAndView("reply/error");
	}
	
}
