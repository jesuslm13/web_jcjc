package jcjc.activityindex.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcjc.activityindex.dao.ActivityIndexDaoImpl;

@Service("activityIndexBiz")
public class ActivityIndexBiz {

	@Autowired
	ActivityIndexDaoImpl dao;
	
	public List<Map<String, Object>> graphData(int politician_no) {
		return dao.graphData(politician_no);
	}
	
}
