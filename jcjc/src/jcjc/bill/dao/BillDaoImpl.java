package jcjc.bill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jcjc.bill.entity.Bill;
import jcjc.mybatis.MybatisUtil;

@Repository("billDao")
public class BillDaoImpl implements BillMapper {

	public int insertBill(Bill billEntity) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		BillMapper mapper = session.getMapper(BillMapper.class);
		int res = mapper.insertBill(billEntity);
		
		session.commit();
		session.close();
		
		return res;
	}

	public int deleteProposer(String proposer) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		BillMapper mapper = session.getMapper(BillMapper.class);
		int res = mapper.deleteProposer(proposer);
		
		session.commit();
		session.close();
		
		return res;
	}

	public int deleteBill() {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		BillMapper mapper = session.getMapper(BillMapper.class);
		int res = mapper.deleteBill();
		
		session.commit();
		session.close();
		
		return res;
	}

	public int updateKimChoiBill(@Param("bill_no")String bill_no, @Param("proposer_hj")String proposer_hj) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		BillMapper mapper = session.getMapper(BillMapper.class);
		int res = mapper.updateKimChoiBill(bill_no, proposer_hj);
		
		session.commit();
		session.close();
		
		return res;
	}

	public List<Bill> selectListBill(@Param("politician_no") int politician_no) {
		
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		BillMapper mapper = session.getMapper(BillMapper.class);
		List<Bill> list = mapper.selectListBill(politician_no);
		
		session.commit();
		session.close();
		
		return list;
	}

	// Bill table에 politician_no 추가
	public int updateBillColPoliticianNo(@Param("proposer")String proposer, @Param("proposer_hj")String proposer_hj, @Param("politician_no")Integer politician_no) {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		BillMapper mapper = session.getMapper(BillMapper.class);
		
		int res = mapper.updateBillColPoliticianNo(proposer, proposer_hj, politician_no);
		
		session.commit();
		session.close();
		
		return res;
	}
	
	public int graphDataTotal() {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		BillMapper mapper = session.getMapper(BillMapper.class);
		
		int res = mapper.graphDataTotal();
		
		session.commit();
		session.close();
		return res;
	}
	
	public int graphDataPolitician(@Param("politician_no") int politician_no) { 
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		BillMapper mapper = session.getMapper(BillMapper.class);
		
		int res = mapper.graphDataPolitician(politician_no);
		
		session.commit();
		session.close();
		return res;
	}
	
	public double graphDataAvg() {
		SqlSession session = MybatisUtil.getSqlSessionfactory().openSession();
		BillMapper mapper = session.getMapper(BillMapper.class);
		
		double res = mapper.graphDataAvg();
		
		session.commit();
		session.close();
		return res;
	}
	
}
