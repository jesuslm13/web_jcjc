package jcjc.user.entity;

public class User {
	private String user_id;
	private String user_password;

	private String user_name;
	private String user_email;
	private String user_birthdate;

	private int user_postcode;
	private String user_road_address;
	private String user_jibun_address;
	private String user_detail_address;
	private String user_extra_address;

	private char user_voting_ex;
	private int user_prefer_politician;
	private int user_support_politician;
	private int user_interest;
	
	public User() {
		super();
	}

	public User(String user_id, String user_password, String user_name, String user_email, String user_birthdate,
			int user_postcode, String user_road_address, String user_jibun_address, String user_detail_address,
			String user_extra_address, char user_voting_ex, int user_prefer_politician, int user_support_politician,
			int user_interest) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_birthdate = user_birthdate;
		this.user_postcode = user_postcode;
		this.user_road_address = user_road_address;
		this.user_jibun_address = user_jibun_address;
		this.user_detail_address = user_detail_address;
		this.user_extra_address = user_extra_address;
		this.user_voting_ex = user_voting_ex;
		this.user_prefer_politician = user_prefer_politician;
		this.user_support_politician = user_support_politician;
		this.user_interest = user_interest;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_birthdate() {
		return user_birthdate;
	}

	public void setUser_birthdate(String user_birthdate) {
		this.user_birthdate = user_birthdate;
	}

	public int getUser_postcode() {
		return user_postcode;
	}

	public void setUser_postcode(int user_postcode) {
		this.user_postcode = user_postcode;
	}

	public String getUser_road_address() {
		return user_road_address;
	}

	public void setUser_road_address(String user_road_address) {
		this.user_road_address = user_road_address;
	}

	public String getUser_jibun_address() {
		return user_jibun_address;
	}

	public void setUser_jibun_address(String user_jibun_address) {
		this.user_jibun_address = user_jibun_address;
	}

	public String getUser_detail_address() {
		return user_detail_address;
	}

	public void setUser_detail_address(String user_detail_address) {
		this.user_detail_address = user_detail_address;
	}

	public String getUser_extra_address() {
		return user_extra_address;
	}

	public void setUser_extra_address(String user_extra_address) {
		this.user_extra_address = user_extra_address;
	}

	public char getUser_voting_ex() {
		return user_voting_ex;
	}

	public void setUser_voting_ex(char user_voting_ex) {
		this.user_voting_ex = user_voting_ex;
	}

	public int getUser_prefer_politician() {
		return user_prefer_politician;
	}

	public void setUser_prefer_politician(int user_prefer_politician) {
		this.user_prefer_politician = user_prefer_politician;
	}

	public int getUser_support_politician() {
		return user_support_politician;
	}

	public void setUser_support_politician(int user_support_politician) {
		this.user_support_politician = user_support_politician;
	}

	public int getUser_interest() {
		return user_interest;
	}

	public void setUser_interest(int user_interest) {
		this.user_interest = user_interest;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_email=" + user_email + ", user_birthdate=" + user_birthdate + ", user_postcode="
				+ user_postcode + ", user_road_address=" + user_road_address + ", user_jibun_address="
				+ user_jibun_address + ", user_detail_address=" + user_detail_address + ", user_extra_address="
				+ user_extra_address + ", user_voting_ex=" + user_voting_ex + ", user_prefer_politician="
				+ user_prefer_politician + ", user_support_politician=" + user_support_politician + ", user_interest="
				+ user_interest + "]";
	}

	
}
