package jcjc.politician.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcjc.politician.dao.PoliticianDaoImpl;
import jcjc.politician.entity.Politician;

@Service("politicianBiz")
public class PoliticianBiz {

	@Autowired
	private PoliticianDaoImpl dao;
	
	public List<Politician> selectAllPolitician() {
		return dao.selectAllPolitician();
	}
	
	public Politician findPolitian(int politician_no) {
		return dao.findPolitician(politician_no);
	}
	
	public List<Politician> searchPolitician(String politician_kor_name){
		return dao.searchPolitician(politician_kor_name);
	}
}
