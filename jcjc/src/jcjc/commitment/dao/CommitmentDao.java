package jcjc.commitment.dao;

public interface CommitmentDao {

	/*
	private int commitment_no; // 공약 번호
	private int politician_no; // 정치인 번호
	private String commitment_proposal_date; // 제안일
	private String commitment_title; // 공약 제목
	private String commitment_content; // 공약 내용
	private String commitment_fulfillment; // 이행 여부
	*/
	
	String select_all_commitment = "select commitment_no, politician_no, "
			+ "to_char(commitment_proposal_date, 'yyyy-mm-dd') "
			+ "as commitment_proposal_date, "
			+ "commitment_title, commitment_content, "
			+ "commitment_fulfillment "
			+ "from commitment "
			+ "order by commitment_no";
	
	String select_list_commitment = "select commitment_no, politician_no, "
			+ "to_char(commitment_proposal_date, 'yyyy-mm-dd') "
			+ "as commitment_proposal_date, "
			+ "commitment_title, commitment_content, "
			+ "commitment_fulfillment "
			+ "from commitment "
			+ "where politician_no = ? "
			+ "order by commitment_no"; 

	String search_commitment = "select * from commitment where politician_no = ?";
	
	String graph_data = "select count(commitment_no) as count "
			+ "from commitment "
			+ "where politician_no = ? "
			+ "and commitment_fulfillment = ?";
	
	
}
