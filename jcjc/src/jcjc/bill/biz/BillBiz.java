package jcjc.bill.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcjc.bill.dao.BillDaoImpl;
import jcjc.bill.entity.Bill;

@Service("billBiz")
public class BillBiz {

	@Autowired
	BillDaoImpl dao;

	public List<Bill> selectListBill(int politician_no) {
		return dao.selectListBill(politician_no);
	}
	
	public int graphDataTotal() {
		return dao.graphDataTotal();
	}
	
	public int graphDataPolitician(int politician_no) {
		return dao.graphDataPolitician(politician_no);
	}
	
	public double graphDataAvg() {
		return dao.graphDataAvg();
	}
}
