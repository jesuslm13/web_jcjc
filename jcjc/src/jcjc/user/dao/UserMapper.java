package jcjc.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jcjc.committee.entitiy.Committee;
import jcjc.politician.entity.Politician;
import jcjc.user.entity.User;

public interface UserMapper {

	@Results(id = "my")
	@Select("select * from user01 where user_id=#{user_id}")
	public User findUser(String user_id);

	@Select("select * from user01")
	public List<User> selectAllUser();

	@Insert("insert into User01 "
			+ "values ("
			+ "#{user_id}, #{user_password}, "
			+ "#{user_name}, #{user_email}, "
			+ "#{user_birthdate}, #{user_postcode}, "
			+ "#{user_road_address}, #{user_jibun_address}, "
			+ "#{user_detail_address}, #{user_extra_address}, "
			+ "#{user_voting_ex}, "
			+ "#{user_prefer_politician}, #{user_support_politician}, " 
			+ "#{user_interest})")
	public int insertUser(User user);

	@Delete("delete from user01 where user_id=#{user_id}")
	public int deleteUser(String user_id);

	@Update("update user01 set user_password=#{user_password}, "
			+ "user_name=#{user_name}, user_email=#{user_email}, "
			+ "user_birthdate=#{user_birthdate}, user_postcode=#{user_postcode},"
			+ "user_road_address=#{user_road_address}, user_jibun_address=#{user_jibun_address}, "
			+ "user_detail_address=#{user_detail_address}, user_extra_address=#{user_extra_address}, "
			+ "user_voting_ex=#{user_voting_ex},"
			+ "user_prefer_politician=#{user_prefer_politician},"
			+ "user_support_politician=#{user_support_politician},"
			+ "user_interest=#{user_interest} "
			+ "where user_id=#{user_id}")
	public int updateUser(User user);
	
	@Select("select * from user01 where user_id=#{user_id} and user_password=#{user_password}")
	public User loginUser(@Param("user_id") String user_id, @Param("user_password") String user_password);
	
	@Select("select user_id from user01 where user_name=#{user_name} and user_email=#{user_email}")
	public String fingId(@Param("user_name") String user_name, @Param("user_email") String user_email);
	
	@Select("select user_password from user01 where user_id=#{user_id} and user_name=#{user_name} and user_email=#{user_email}")
	public String findPassword(@Param("user_id") String user_id,@Param("user_name") String user_name, @Param("user_email") String user_email);
	
	@Select("select * from jurisdiction_committee")
	public List<Committee> selectAllCommittee();
}
