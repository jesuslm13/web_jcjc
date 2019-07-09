package jcjc.politician.entity;

public class Politician {

	private int politician_no; 
	private String politician_kor_name;
	private String politician_hj_name;
	private String politician_eng_name;
	private String bth_date;
	private String poly_name;
	private String orig_name;
	private String shrt_name;
	private String reele_gbn_name;
	private String election_name;
	private String assem_tel;
	private String assem_homep;
	private String assem_email;
	private String hbby_cd;
	private String exam_cd;
	private String politician_jpg_link;
	
	public Politician() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Politician(int politician_no, String politician_kor_name, String politician_hj_name,
			String politician_eng_name, String bth_date, String poly_name, String orig_name, String shrt_name,
			String reele_gbn_name, String election_name, String assem_tel, String assem_homep, String assem_email,
			String hbby_cd, String exam_cd, String politician_jpg_link) {
		super();
		this.politician_no = politician_no;
		this.politician_kor_name = politician_kor_name;
		this.politician_hj_name = politician_hj_name;
		this.politician_eng_name = politician_eng_name;
		this.bth_date = bth_date;
		this.poly_name = poly_name;
		this.orig_name = orig_name;
		this.shrt_name = shrt_name;
		this.reele_gbn_name = reele_gbn_name;
		this.election_name = election_name;
		this.assem_tel = assem_tel;
		this.assem_homep = assem_homep;
		this.assem_email = assem_email;
		this.hbby_cd = hbby_cd;
		this.exam_cd = exam_cd;
		this.politician_jpg_link = politician_jpg_link;
	}
	public int getPolitician_no() {
		return politician_no;
	}
	public void setPolitician_no(int politician_no) {
		this.politician_no = politician_no;
	}
	public String getPolitician_kor_name() {
		return politician_kor_name;
	}
	public void setPolitician_kor_name(String politician_kor_name) {
		this.politician_kor_name = politician_kor_name;
	}
	public String getPolitician_hj_name() {
		return politician_hj_name;
	}
	public void setPolitician_hj_name(String politician_hj_name) {
		this.politician_hj_name = politician_hj_name;
	}
	public String getPolitician_eng_name() {
		return politician_eng_name;
	}
	public void setPolitician_eng_name(String politician_eng_name) {
		this.politician_eng_name = politician_eng_name;
	}
	public String getBth_date() {
		return bth_date;
	}
	public void setBth_date(String bth_date) {
		this.bth_date = bth_date;
	}
	public String getPoly_name() {
		return poly_name;
	}
	public void setPoly_name(String poly_name) {
		this.poly_name = poly_name;
	}
	public String getOrig_name() {
		return orig_name;
	}
	public void setOrig_name(String orig_name) {
		this.orig_name = orig_name;
	}
	public String getShrt_name() {
		return shrt_name;
	}
	public void setShrt_name(String shrt_name) {
		this.shrt_name = shrt_name;
	}
	public String getReele_gbn_name() {
		return reele_gbn_name;
	}
	public void setReele_gbn_name(String reele_gbn_name) {
		this.reele_gbn_name = reele_gbn_name;
	}
	public String getElection_name() {
		return election_name;
	}
	public void setElection_name(String election_name) {
		this.election_name = election_name;
	}
	public String getAssem_tel() {
		return assem_tel;
	}
	public void setAssem_tel(String assem_tel) {
		this.assem_tel = assem_tel;
	}
	public String getAssem_homep() {
		return assem_homep;
	}
	public void setAssem_homep(String assem_homep) {
		this.assem_homep = assem_homep;
	}
	public String getAssem_email() {
		return assem_email;
	}
	public void setAssem_email(String assem_email) {
		this.assem_email = assem_email;
	}
	public String getHbby_cd() {
		return hbby_cd;
	}
	public void setHbby_cd(String hbby_cd) {
		this.hbby_cd = hbby_cd;
	}
	public String getExam_cd() {
		return exam_cd;
	}
	public void setExam_cd(String exam_cd) {
		this.exam_cd = exam_cd;
	}
	public String getPolitician_jpg_link() {
		return politician_jpg_link;
	}
	public void setPolitician_jpg_link(String politician_jpg_link) {
		this.politician_jpg_link = politician_jpg_link;
	}
	@Override
	public String toString() {
		return "Politician [politician_no=" + politician_no + ", politician_kor_name=" + politician_kor_name
				+ ", politician_hj_name=" + politician_hj_name + ", politician_eng_name=" + politician_eng_name
				+ ", bth_date=" + bth_date + ", poly_name=" + poly_name + ", orig_name=" + orig_name + ", shrt_name="
				+ shrt_name + ", reele_gbn_name=" + reele_gbn_name + ", election_name=" + election_name + ", assem_tel="
				+ assem_tel + ", assem_homep=" + assem_homep + ", assem_email=" + assem_email + ", hbby_cd=" + hbby_cd
				+ ", exam_cd=" + exam_cd + ", politician_jpg_link=" + politician_jpg_link + "]";
	}

}
