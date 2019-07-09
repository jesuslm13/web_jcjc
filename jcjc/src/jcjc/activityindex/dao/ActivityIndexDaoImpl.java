package jcjc.activityindex.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("activityIndexDao")
public class ActivityIndexDaoImpl implements ActivityIndexDao{

	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	
	public List<Map<String, Object>> graphData(int politician_no) {
		List<Map<String, Object>> list = jdbcTemplate.query(select_activity_index, 
				new Object [] {politician_no}, new RowMapper<Map<String,Object>>() {
			@Override
			public HashMap<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("committee", rs.getString("committee_name"));
				map.put("count", rs.getInt("count"));
				return map;
			}
		});
		return  list;
	}

}
