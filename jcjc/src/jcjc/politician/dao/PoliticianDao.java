package jcjc.politician.dao;

public interface PoliticianDao {
	
//	private int politician_no;
//	private String politician_num;
//	private String politician_kor_name;
//	private String politician_hj_name;
//	private String politician_eng_name;
//	private String politician_reele_gbn_nm;
//	private String politician_location;
//	private String politician_jpg_link;
	
	String select_all_politician = "select * from politician order by politician_no";

	String find_politician = "select * from politician "
			+ "where politician_no = ?";
	
	String search_politician = "select * from politician "
			+ "where politician_kor_name like %?%";
}
