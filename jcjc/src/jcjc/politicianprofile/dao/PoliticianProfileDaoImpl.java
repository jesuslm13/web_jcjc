package jcjc.politicianprofile.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jcjc.mybatis.MybatisUtil;
import jcjc.politician.entity.Politician;
import jcjc.politicianprofile.entity.PoliticianProfileEntity;

@Repository
public class PoliticianProfileDaoImpl implements PoliticianProfileMapper{

	public int insertProfile(PoliticianProfileEntity entity) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PoliticianProfileMapper mapper = session.getMapper(PoliticianProfileMapper.class);
		int res = mapper.insertProfile(entity);
		
		session.commit();
		session.close();
		
		return res;
	}

	public int deleteProfile() {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PoliticianProfileMapper mapper = session.getMapper(PoliticianProfileMapper.class);
		int res = mapper.deleteProfile();
		
		session.commit();
		session.close();
		
		return res;
	}
	
	// Politician insert
//	@Override
//	public int insertPolitician(Politician entity) {
//		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
//		PoliticianProfileMapper mapper = session.getMapper(PoliticianProfileMapper.class);
//		int res = mapper.insertPolitician(entity);
//		
//		session.commit();
//		session.close();
//		
//		return res;
//	}
//	politician_no number,
//	politician_num number,
//	politician_kor_name varchar2(1000),
//	politician_hj_name varchar2(1000),
//	politician_eng_name varchar2(1000),
//	bth_date date,
//	poly_name varchar2(1000),
//	orig_name varchar2(1000),
//	shrt_name varchar2(1000),
//	reele_gbn_name varchar2(1000),
//	election_name varchar2(1000),
//	assem_tel varchar2(1000),
//	assem_homep varchar2(1000),
//	assem_email varchar2(1000),
//	hbby_cd varchar2(1000),
//	exam_cd varchar2(1000),
//	politician_jpg_link varchar2(1000)
//	);
	public int updatePoliticianNo(@Param("politician_kor_name")String politician_kor_name, @Param("orig_name")String orig_name, @Param("politician_no")Integer politician_no) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PoliticianProfileMapper mapper = session.getMapper(PoliticianProfileMapper.class);
		int res = mapper.updatePoliticianNo(politician_kor_name, orig_name, politician_no);
		
		session.commit();
		session.close();
		
		return res;
	}

	public int updatePoliticianNum(@Param("politician_kor_name")String politician_kor_name, @Param("orig_name")String orig_name, @Param("politician_num")Integer politician_num) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PoliticianProfileMapper mapper = session.getMapper(PoliticianProfileMapper.class);
		int res = mapper.updatePoliticianNum(politician_kor_name, orig_name, politician_num);
		
		session.commit();
		session.close();
		
		return res;
	}

	public int updatePoliticianJpgLinkList(@Param("politician_kor_name")String politician_kor_name, @Param("orig_name")String orig_name, @Param("politician_jpg_link")String politician_jpg_link) {

		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		PoliticianProfileMapper mapper = session.getMapper(PoliticianProfileMapper.class);
		int res = mapper.updatePoliticianJpgLinkList(politician_kor_name, orig_name, politician_jpg_link);
		
		session.commit();
		session.close();
		
		return res;
	}

}
