package jcjc.reply.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jcjc.reply.entity.Reply;

@Repository("replyDao")
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	public class ReplyRowMapper implements RowMapper<Reply>{
		@Override
		public Reply mapRow(ResultSet rs, int rowNum) throws SQLException {
			Reply entity = new Reply(
					rs.getInt("reply_no"), 
					rs.getInt("post_no"),
					rs.getString("user_id"), 
					rs.getString("reply_content"), 
					rs.getString("reply_date"));
			return entity;
		}			
	}
	
	public List<Reply> selectAllReply(){
		List<Reply> entityList = jdbctemplate.query(select_all_post, new ReplyRowMapper());
		return entityList;
	}
	
	public List<Reply> selectListReply(int post_no) {
		List<Reply> entityList = jdbctemplate.query(select_list_post, 
				new Object[] { post_no }, new ReplyRowMapper());
		return entityList;
	}
	
	public int insertReply(Reply reply) {
		int res = jdbctemplate.update(insert_reply, 
				new Object[] {
						reply.getPost_no(),
						reply.getUser_id(),
						reply.getReply_content(),
						reply.getReply_date()
				});
		return res;
	}
	
	public int updateReply(Reply reply) {
		int res = jdbctemplate.update(update_reply,
				new Object[] {
						reply.getReply_content(),
						reply.getReply_date(),
						reply.getReply_no()
				});
		return res;
	}
	
	public int deleteReply(int reply_no) {
		int res = jdbctemplate.update(delete_reply, new Object[] { reply_no });
		return res;
	}

	public List<Reply> findReply(String user_id) {
		List<Reply> entityList = jdbctemplate.query(find_reply, 
				new Object[] { user_id }, new ReplyRowMapper());
		return entityList;
	}

	public Reply searchReply(int reply_no, String user_id) {
		Reply entityList = jdbctemplate.queryForObject(search_reply, 
				new Object[] { reply_no, user_id }, new ReplyRowMapper());
		return entityList;
	}
}
