package jcjc.reply.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcjc.reply.dao.ReplyDaoImpl;
import jcjc.reply.entity.Reply;

@Service("replyBiz")
public class ReplyBiz {
	
	@Autowired
	private ReplyDaoImpl dao;
	
	public List<Reply> selectAllReply(){
		return dao.selectAllReply();
	}

	public List<Reply> selectListReply(int post_no){
		return dao.selectListReply(post_no);
	}

	public List<Reply> findReply(String user_id) {
		return dao.findReply(user_id);
	}	
	public int insertReply(Reply replyentity) {
		return dao.insertReply(replyentity);
	}	
	public int updateReply(Reply replyentity) {
		return dao.updateReply(replyentity);
	}
	public int deleteReply(int reply_no) {
		return dao.deleteReply(reply_no);
	}
	
	public Reply searchReply(int reply_no, String user_id) {
		return dao.searchReply(reply_no, user_id);
	}
}
