package jcjc.post.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcjc.post.dao.PostDaoImpl;
import jcjc.post.entity.Post;

@Service("postBiz")
public class PostBiz {
	@Autowired
	private PostDaoImpl dao;

	public List<Post> selectAllPost() {
		return dao.selectAllPost();
	}
	public List<Post> selectListPost(int commitment_no) {
		return dao.selectListPost(commitment_no);
	}
	public List<Post> findPost(String user_id) {
		return dao.findPost(user_id);
	}
	public int insertPost(Post post) {
		return dao.insertPost(post);
	}
	public int updatePost(Post post) {
		return dao.updatePost(post);
	}
	public int deletePost(int post_no) {
		return dao.deletePost(post_no);
	}
	
	public Post detailPost(int post_no) {
		return dao.detailPost(post_no);
	}
	
	
	///////////////////////////////////////////
	
	public Post searchPost(int post_no, String user_id) {
		return dao.searchPost(post_no, user_id);
	}
	
	
	public Double avgScorePost(int commitment_no) {
		return dao.avgScorePost(commitment_no);
	}
}
