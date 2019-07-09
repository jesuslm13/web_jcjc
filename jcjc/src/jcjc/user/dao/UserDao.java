package jcjc.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jcjc.committee.entitiy.Committee;
import jcjc.mybatis.MybatisUtil;
import jcjc.politician.entity.Politician;
import jcjc.user.entity.User;

@Repository("userDao")
public class UserDao implements UserMapper {

	@Override
	public User findUser(String user_id) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.findUser(user_id);
		session.close();
		return user;
	}

	@Override
	public List<User> selectAllUser() {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> all = mapper.selectAllUser();
		session.close();
		return all;
	}

	@Override
	public int insertUser(User user) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int res = mapper.insertUser(user);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public int deleteUser(String user_id) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int res = mapper.deleteUser(user_id);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public int updateUser(User user) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int res = mapper.updateUser(user);
		session.commit();
		session.close();
		return res;
	}

	@Override
	public User loginUser(String user_id,String user_password) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.loginUser(user_id, user_password);
		session.close();
		return user;
	}

	@Override
	public String fingId(String user_name, String user_email) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		String res = mapper.fingId(user_name, user_email);
		return res;
	}

	@Override
	public String findPassword(String user_id, String user_name, String user_email) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		String res = mapper.findPassword(user_id, user_name, user_email);
		return res;
	}
	/*
	public List<Politician> selectAllPolitician() {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Politician> list = mapper.selectAllPolitician();
		session.close();
		return list;
		
	}

	public List<Politician> findPolitician(String findpolitician) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Politician> list = mapper.findPolitician(findpolitician);
		return list;
	}
	*/
	public List<Committee> selectAllCommittee() {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Committee> list = mapper.selectAllCommittee();
		
		return list;
	}

}
