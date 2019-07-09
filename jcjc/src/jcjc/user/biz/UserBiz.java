package jcjc.user.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcjc.committee.entitiy.Committee;
import jcjc.politician.entity.Politician;
import jcjc.user.dao.UserDao;
import jcjc.user.entity.User;

@Service("userBiz")
public class UserBiz {
	
	@Autowired
	private UserDao dao;
	
	
	public User findUser(String user_id) {		
		return dao.findUser(user_id);
	}

	
	public List<User> selectAllUser() {		
		return dao.selectAllUser();
	}

	
	public int insertUser(User user) {
		return dao.insertUser(user);
	}

	public int deleteUser(String user_id) {
		return dao.deleteUser(user_id);
	}

	public int updateUser(User user) {
		return dao.updateUser(user);
	}

	public User loginUser(String user_id, String user_password) {
		return dao.loginUser(user_id, user_password);
	}
	
	public String findId(String user_name, String user_email) {
		return dao.fingId(user_name, user_email);
	}
	
	public String findPassword(String user_id, String user_name, String user_email) {
		return dao.findPassword(user_id, user_name, user_email);
	}
	
	
	
	public List<Committee> selectAllCommittee() {

		return dao.selectAllCommittee();
	}
}
