package jcjc.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jcjc.commitment.entity.Commitment;
import jcjc.politician.entity.Politician;
import jcjc.post.entity.Post;

public interface PostMapper {
	
	@Select("select post_no, "
			+ "commitment_no, "
			+ "user_id, "
			+ "post_score, "
			+ "post_title, "
			+ "post_content, "
			+ "to_char(post_date, 'yyyy-mm-dd hh24:mi:ss') as post_date "
			+ "from post "
			+ "order by post_no"
	)
	List<Post> selectAllPost();

	@Select("select post_no, "
			+ "commitment_no, "
			+ "user_id, "
			+ "post_score, "
			+ "post_title, "
			+ "post_content, "
			+ "to_char(post_date, 'yyyy-mm-dd hh24:mi:ss') as post_date "
			+ "from post "
			+ "where commitment_no = #{commitment_no} "
			+ "order by post_no"
	)
	List<Post> selectListPost(int commitment_no);

	@Select("select * from post where user_id = #{user_id}")
	List<Post> findPost(String user_id);

	@Insert("insert into post values("
			+ "seq_post.nextval, "
			+ "#{commitment_no}, "
			+ "#{user_id}, "
			+ "#{post_score}, "
			+ "#{post_title}, "
			+ "#{post_content}, "
			+ "to_date(#{post_date}, 'yyyy-mm-dd hh24:mi:ss'))"
	)
	int insertPost(Post post);
	
	@Update("update post set "
			+ "post_score = #{post_score}, "
			+ "post_title = #{post_title}, "
			+ "post_content = #{post_content}, "
			+ "post_date = to_date(#{post_date}, 'yyyy-mm-dd hh24:mi:ss') "
			+ "where post_no = #{post_no}"
	)
	int updatePost(Post post);

	@Delete("delete from post where post_no = #{post_no}")
	int deletePost(int post_no);

	@Select("select * from post where post_no = #{post_no} and user_id = #{user_id}")
	Post searchPost(@Param("post_no") int post_no, @Param("user_id") String user_id);

	@Select("select * from post where post_no = #{post_no}")
	Post detailPost(int post_no);

	@Select("select "
			+ "round(nvl(avg(post_score), 0), 2) as avg_score "
			+ "from post "
			+ "where commitment_no = #{commitment_no}"
	)
	Double avgScorePost(int commitment_no);

	@Select("select "
			+ "round(nvl(avg(post_score), 0), 2) as avg_score "
			+ "from post "
			+ "where commitment_no = #{commitment_no}"
	)
	Double selectCommitmentAvg(int commitment_no);
	
	
	
	
	

	
}
