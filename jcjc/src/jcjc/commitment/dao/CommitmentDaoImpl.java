package jcjc.commitment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jcjc.bill.dao.BillMapper;
import jcjc.commitment.entity.Commitment;
import jcjc.commitment.entity.CommitmentEntity;
import jcjc.mybatis.MybatisUtil;
import jcjc.politician.entity.Politician;
import jcjc.post.entity.Post;

@Repository("commitmentDao")
public class CommitmentDaoImpl implements CommitmentMapper {
	
	public List<Commitment> selectAllCommitment(){
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		CommitmentMapper mapper = session.getMapper(CommitmentMapper.class);
		List<Commitment> res = mapper.selectAllCommitment();
		
		session.commit();
		session.close();
		
		return res;
		
	}
	
	public List<Commitment> selectListCommitment(Politician politician){
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		CommitmentMapper mapper = session.getMapper(CommitmentMapper.class);
		// mapper.selectListCommitment();
		List<Commitment> res = mapper.selectListCommitment(politician);
		session.commit();
		session.close();
		
		return res;
	}
	
	public int graphData(@Param("politician_no") int politician_no, @Param("commitment_fulfillment") String commitment_fulfillment) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		CommitmentMapper mapper = session.getMapper(CommitmentMapper.class);
		int res = mapper.graphData(politician_no, commitment_fulfillment);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	public class CommitmentRowMapper implements RowMapper<Commitment> {
//		@Override
//		public Commitment mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Commitment entity = new Commitment(
//					rs.getInt("commitment_no"),
//					rs.getInt("politician_no"),
//					rs.getString("commitment_proposal_date"),
//					rs.getString("commitment_title"),
//					rs.getString("commitment_content"),
//					rs.getString("commitment_fulfillment"));	
//			return entity;
//		}
//	}
//	
//	public List<Commitment> selectAllCommitment() {
//		List<Commitment> entityList = jdbcTemplate.query(select_all_commitment, new CommitmentRowMapper());
//		return entityList;
//	}
//	
//	public List<Commitment> selectListCommitment(int politician_no) {
//		List<Commitment> entityList = jdbcTemplate.query(select_list_commitment, 
//				new Object[] {politician_no}, new CommitmentRowMapper());
//		return entityList;
//	}
//	
//	public int graphData(int politician_no, String fulfillment) {
//		int res = jdbcTemplate.queryForObject(graph_data, 
//				new Object[] { politician_no, fulfillment }, new RowMapper<Integer>() {
//					@Override
//					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Integer entity = new Integer(rs.getInt("count"));
//						return entity;
//					}
//		});
//		return res;
//	}
}
