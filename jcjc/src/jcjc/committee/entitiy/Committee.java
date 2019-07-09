package jcjc.committee.entitiy;

public class Committee {

	private int jurisdiction_committee_code;
	private String jurisdiction_committee_name;
	
	public Committee() {
		super();
	}

	public Committee(int jurisdiction_committee_code, String jurisdiction_committee_name) {
		super();
		this.jurisdiction_committee_code = jurisdiction_committee_code;
		this.jurisdiction_committee_name = jurisdiction_committee_name;
	}

	public int getJurisdiction_committee_code() {
		return jurisdiction_committee_code;
	}

	public void setJurisdiction_committee_code(int jurisdiction_committee_code) {
		this.jurisdiction_committee_code = jurisdiction_committee_code;
	}

	public String getJurisdiction_committee_name() {
		return jurisdiction_committee_name;
	}

	public void setJurisdiction_committee_name(String jurisdiction_committee_name) {
		this.jurisdiction_committee_name = jurisdiction_committee_name;
	}

	@Override
	public String toString() {
		return "Committee [jurisdiction_committee_code=" + jurisdiction_committee_code
				+ ", jurisdiction_committee_name=" + jurisdiction_committee_name + "]";
	}
}
