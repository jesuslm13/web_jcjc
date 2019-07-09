package jcjc.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jcjc.commitment.entity.Commitment;
import jcjc.mybatis.MybatisUtil;
import jcjc.post.entity.Post;

@Repository("postDao")
public class PostDaoImpl implements PostMapper {
	
	public List<Post> selectAllPost(){
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		List<Post> res = mapper.selectAllPost();
		
		session.commit();
		session.close();
		
		return res;
	
	}
	
	public List<Post> selectListPost(int commitment_no) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		List<Post> res = mapper.selectListPost(commitment_no);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	public List<Post> findPost(String user_id) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		List<Post> res = mapper.findPost(user_id);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	public int insertPost(Post post) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		int res = mapper.insertPost(post);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	public int updatePost(Post post) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		int res = mapper.updatePost(post);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	public int deletePost(int post_no) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		int res = mapper.deletePost(post_no);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	public Post searchPost(@Param("post_no") int post_no, @Param("user_id") String user_id) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		Post res = mapper.searchPost(post_no, user_id);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	public Post detailPost(int post_no) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		Post res = mapper.detailPost(post_no);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	public Double avgScorePost(int commitment_no) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		Double res = mapper.avgScorePost(commitment_no);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	public Double selectCommitmentAvg(int commitment_no){
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PostMapper mapper = session.getMapper(PostMapper.class);
		Double res = mapper.selectCommitmentAvg(commitment_no);
		
		session.commit();
		session.close();
		
		return res;
	}
	
//	@Autowired
//	JdbcTemplate jdbctemplate;
//	
//	public class PostRowMapper implements RowMapper<Post> {
//		@Override
//		public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Post entity = new Post(
//					rs.getInt("post_no"),
//					rs.getInt("commitment_no"),
//					rs.getString("user_id"),
//					rs.getInt("post_score"),
//					rs.getString("post_title"),
//					rs.getString("post_content"),
//					rs.getString("post_date"));
//			return entity;
//		}
//	}
//	
//	public List<Post> selectAllPost(){
//		List<Post> entityList = jdbctemplate.query(select_all_post, new PostRowMapper());
//		return entityList;
//	}
//
//	
//	public List<Post> selectListPost(int commitment_no){
//		List<Post> entityList = null;
//		try {
//			entityList = jdbctemplate.query(select_list_post, 
//					new Object[] { commitment_no }, new PostRowMapper());
//		} catch (Exception e) {
//			return null;
//		}
//		return entityList;
//	}
//	
//	
//	public List<Post> findPost(String user_id) {
//		List<Post> entityList = jdbctemplate.query(find_post, 
//				new Object[] { user_id }, new PostRowMapper());
//		return entityList;
//	}
//	
//	
//	
//	public int insertPost(Post post) {
//		int res = jdbctemplate.update(insert_post, 
//				new Object[] {post.getCommitment_no(),
//						post.getUser_id(),post.getPost_score(),
//						post.getPost_title(), post.getPost_content(),
//						post.getPost_date()
//				});
//		return res;
//	}
//	
//	
//	public int updatePost(Post post) {
//		int res =  jdbctemplate.update(update_post,
//				new Object[] {post.getPost_score(),
//						post.getPost_title(), post.getPost_content(),
//						post.getPost_date(), 
//						post.getPost_no()
//				});
//		return res;
//	}
//	
//	public int deletePost(int post_no) {
//		int res = jdbctemplate.update(delete_post, 
//				new Object[] {post_no});
//		return res;
//	}
//	
//	///////////////////////////////////////////////////////////
//	///////////////////////////////////////////////////////////	
//	///////////////////////////////////////////////////////////
//	public Post searchPost(int post_no, String user_id) {
//		Post post = jdbctemplate.queryForObject(search_post, 
//				new Object[] { post_no, user_id }, new PostRowMapper());
//		return post;
//	}
//
//
//	public Post detailPost(int post_no) {
//		Post post = jdbctemplate.queryForObject(detail_post, 
//				new Object[] { post_no }, new RowMapper<Post>() {
//			@Override
//			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Post entity = new Post(rs.getInt("post_no"), rs.getInt("commitment_no"), 
//						rs.getString("user_id"), rs.getInt("post_score"),
//						rs.getString("post_title"), rs.getString("post_content"), 
//						rs.getString("post_date"));		
//				return entity;
//			}
//		});
//		return post;
//	}
//	
//	public Double avgScorePost(int commitment_no) {
//		Double res = jdbctemplate.queryForObject(avg_score_post, 
//				new Object[] { commitment_no }, new RowMapper<Double>() {
//					@Override
//					public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Double entity = new Double(rs.getDouble("avg_score"));
//						return entity;
//					}
//				});
//		return res;				
//	}
//	
//	// commitment avg
//	public Double selectCommitmentAvg(int commitment_no){
//		Double res = jdbctemplate.queryForObject(avg_score_post, new Object[] {commitment_no}, new RowMapper<Double>() {
//
//			@Override
//			public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
//				
//				Double commitment_avg = new Double(rs.getDouble(1));
//				
//				return commitment_avg;
//			}
//		});
//		return res;
//	}
}
