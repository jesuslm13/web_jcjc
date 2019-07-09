package jcjc.post.entity;

public class Post {
	private int post_no; // 게시물 번호
	private int commitment_no; // 공약번호
	private String user_id; // 작성자 id
	private int post_score; // 별점
	private String post_title; // 게시물 제목
	private String post_content; // 게시물 내용
	private String post_date; // 작성일
	
	public Post() {
		super();
	}

	public Post(int post_no, int commitment_no, String user_id, int post_score, String post_title,
			String post_content, String post_date) {
		super();
		this.post_no = post_no;
		this.commitment_no = commitment_no;
		this.user_id = user_id;
		this.post_score = post_score;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_date = post_date;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getCommitment_no() {
		return commitment_no;
	}
	public void setCommitment_no(int commitment_no) {
		this.commitment_no = commitment_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPost_score() {
		return post_score;
	}
	public void setPost_score(int post_score) {
		this.post_score = post_score;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public String getPost_date() {
		return post_date;
	}
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	@Override
	public String toString() {
		return "Post [post_no=" + post_no + ", commitment_no=" + commitment_no + ", user_id=" + user_id
				+ ", post_score=" + post_score + ", post_title=" + post_title + ", post_content=" + post_content
				+ ", post_date=" + post_date + "]";
	}
}
