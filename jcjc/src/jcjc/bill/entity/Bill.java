package jcjc.bill.entity;

public class Bill {
	
//   bill_no varchar2(1000) primary key,
//   bill_name varchar2(1000),
//   politician_no number,
//   proposer varchar2(1000),
//   proposer_hj varchar2(10),
//   proposer_kind varchar2(1000),
//   propose_dt date,
//   submit_dt date,
//   committee_name varchar2(1000),
//   proc_dt date,
//   general_result varchar2(1000)
	
	private String bill_no;
	private String bill_name;
	private int politician_no;
	private String proposer;
	private String proposer_hj;
	private String proposer_kind;
	private String propose_dt;
	private String submit_dt;
	private String committee_name;
	private String proc_dt;
	private String general_result;
	
	public Bill() {
		super();
	}

	public Bill(String bill_no, String bill_name, int politician_no, String proposer, String proposer_hj,
			String proposer_kind, String propose_dt, String submit_dt, String committee_name, String proc_dt,
			String general_result) {
		super();
		this.bill_no = bill_no;
		this.bill_name = bill_name;
		this.politician_no = politician_no;
		this.proposer = proposer;
		this.proposer_hj = proposer_hj;
		this.proposer_kind = proposer_kind;
		this.propose_dt = propose_dt;
		this.submit_dt = submit_dt;
		this.committee_name = committee_name;
		this.proc_dt = proc_dt;
		this.general_result = general_result;
	}

	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public String getBill_name() {
		return bill_name;
	}

	public void setBill_name(String bill_name) {
		this.bill_name = bill_name;
	}

	public int getPolitician_no() {
		return politician_no;
	}

	public void setPolitician_no(int politician_no) {
		this.politician_no = politician_no;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public String getProposer_hj() {
		return proposer_hj;
	}

	public void setProposer_hj(String proposer_hj) {
		this.proposer_hj = proposer_hj;
	}

	public String getProposer_kind() {
		return proposer_kind;
	}

	public void setProposer_kind(String proposer_kind) {
		this.proposer_kind = proposer_kind;
	}

	public String getPropose_dt() {
		return propose_dt;
	}

	public void setPropose_dt(String propose_dt) {
		this.propose_dt = propose_dt;
	}

	public String getSubmit_dt() {
		return submit_dt;
	}

	public void setSubmit_dt(String submit_dt) {
		this.submit_dt = submit_dt;
	}

	public String getCommittee_name() {
		return committee_name;
	}

	public void setCommittee_name(String committee_name) {
		this.committee_name = committee_name;
	}

	public String getProc_dt() {
		return proc_dt;
	}

	public void setProc_dt(String proc_dt) {
		this.proc_dt = proc_dt;
	}

	public String getGeneral_result() {
		return general_result;
	}

	public void setGeneral_result(String general_result) {
		this.general_result = general_result;
	}

	@Override
	public String toString() {
		return "Bill [bill_no=" + bill_no + ", bill_name=" + bill_name + ", politician_no=" + politician_no
				+ ", proposer=" + proposer + ", proposer_hj=" + proposer_hj + ", proposer_kind=" + proposer_kind
				+ ", propose_dt=" + propose_dt + ", submit_dt=" + submit_dt + ", committee_name=" + committee_name
				+ ", proc_dt=" + proc_dt + ", general_result=" + general_result + "]";
	}
}