package jcjc.commitment.entity;

public class Commitment { // 공약
	
	private int commitment_no; // 공약 번호
	private int politician_no; // 정치인 번호
	private String commitment_proposal_date; // 제안일
	private String commitment_title; // 공약 제목
	private String commitment_content; // 공약 내용
	private String commitment_fulfillment; // 이행 여부
	
	public Commitment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commitment(int commitment_no, int politician_no, String commitment_proposal_date, String commitment_title,
			String commitment_content, String commitment_fulfillment) {
		super();
		this.commitment_no = commitment_no;
		this.politician_no = politician_no;
		this.commitment_proposal_date = commitment_proposal_date;
		this.commitment_title = commitment_title;
		this.commitment_content = commitment_content;
		this.commitment_fulfillment = commitment_fulfillment;
	}
	public int getCommitment_no() {
		return commitment_no;
	}
	public void setCommitment_no(int commitment_no) {
		this.commitment_no = commitment_no;
	}
	public int getPolitician_no() {
		return politician_no;
	}
	public void setPolitician_no(int politician_no) {
		this.politician_no = politician_no;
	}
	public String getCommitment_proposal_date() {
		return commitment_proposal_date;
	}
	public void setCommitment_proposal_date(String commitment_proposal_date) {
		this.commitment_proposal_date = commitment_proposal_date;
	}
	public String getCommitment_title() {
		return commitment_title;
	}
	public void setCommitment_title(String commitment_title) {
		this.commitment_title = commitment_title;
	}
	public String getCommitment_content() {
		return commitment_content;
	}
	public void setCommitment_content(String commitment_content) {
		this.commitment_content = commitment_content;
	}
	public String getCommitment_fulfillment() {
		return commitment_fulfillment;
	}
	public void setCommitment_fulfillment(String commitment_fulfillment) {
		this.commitment_fulfillment = commitment_fulfillment;
	}
	@Override
	public String toString() {
		return "Commitment [commitment_no=" + commitment_no + ", politician_no=" + politician_no
				+ ", commitment_proposal_date=" + commitment_proposal_date + ", commitment_title=" + commitment_title
				+ ", commitment_content=" + commitment_content + ", commitment_fulfillment=" + commitment_fulfillment
				+ "]";
	}
	
}
