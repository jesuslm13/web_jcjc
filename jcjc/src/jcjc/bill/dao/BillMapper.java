package jcjc.bill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jcjc.bill.entity.Bill;

public interface BillMapper {

	@Insert("insert into bill values (#{bill_no}, #{bill_name}, #{politician_no}, #{proposer}, #{proposer_hj}, #{proposer_kind}, to_date(#{propose_dt},'yyyy-mm-dd'), to_date(#{submit_dt},'yyyy-mm-dd'), #{committee_name}, to_date(#{proc_dt},'yyyy-mm-dd'), #{general_result})")
	public int insertBill(Bill billentity);
	
	@Delete("delete from bill where proposer=#{proposer}")
	public int deleteProposer(String proposer);

	@Delete("delete from bill")
	public int deleteBill();

	@Update("update bill set proposer_hj=#{proposer_hj} where bill_no=#{bill_no}")
	public int updateKimChoiBill(@Param("bill_no")String bill_no, @Param("proposer_hj")String proposer_hj);

	@Select("select * from bill where politician_no=#{politician_no}")
	public List<Bill> selectListBill(@Param("politician_no") int politician_no);

	@Update("update bill set politician_no=#{politician_no} where proposer=#{proposer} and proposer_hj=#{proposer_hj}")
	public int updateBillColPoliticianNo(@Param("proposer")String proposer, @Param("proposer_hj")String proposer_hj, @Param("politician_no")Integer politician_no);
	
	
	/*
	"select count(commitment_no) as count from bill "
	"where politician_no = ? "
	"and commitment_fulfillment = ?";
	 */
	@Select("select count(bill_no) as count from bill where proposer_kind='의원'")
	public int graphDataTotal();
	
	@Select("select count(bill_no) as count from bill where politician_no=#{politician_no}")
	public int graphDataPolitician(@Param("politician_no") int politician_no);

	@Select("select round(avg(count),2) "
			+ "from (" 
			+ "select count(bill_no) as count, politician_no "
			+ "from bill "
			+ "group by politician_no "
			+ "having politician_no not in (0)" 
			+ ")")
	public double graphDataAvg();
}
