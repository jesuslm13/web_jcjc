package jcjc.politician.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jcjc.politician.entity.Politician;

@Repository("politicianDao")
public class PoliticianDaoImpl implements PoliticianDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public class PoliticianRowMapper implements RowMapper<Politician> {
		@Override
		public Politician mapRow(ResultSet rs, int rowNum) throws SQLException {
			Politician entity = new Politician(
					rs.getInt("politician_no"),
					rs.getString("politician_kor_name"),
					rs.getString("politician_hj_name"),
					rs.getString("politician_eng_name"),
					rs.getString("bth_date"),
					rs.getString("poly_name"),
					rs.getString("orig_name"),
					rs.getString("shrt_name"),
					rs.getString("reele_gbn_name"),
					rs.getString("election_name"),
					rs.getString("assem_tel"),
					rs.getString("assem_homep"),
					rs.getString("assem_email"),
					rs.getString("hbby_cd"),
					rs.getString("exam_cd"),
					rs.getString("politician_jpg_link"));
			return entity;
		}
	}
	
	public List<Politician> selectAllPolitician() {
		List<Politician> entityList = jdbcTemplate.query(select_all_politician, 
				new PoliticianRowMapper());
		return entityList;
	}
	
	public Politician findPolitician(int politician_no) {
		Politician politician = jdbcTemplate.queryForObject(find_politician,
				new Object[] {politician_no}, new PoliticianRowMapper());
		return politician; 
	}
	
	
	public List<Politician> searchPolitician(String politician_kor_name) {
		List<Politician> entityList = jdbcTemplate.query(search_politician, 
				new Object[] {politician_kor_name}, new PoliticianRowMapper());
		return entityList;
	}
}
