package jcjc.reply.entity;

public class Reply {

	private int reply_no; // 댓글 번호
	private int post_no; // 게시물 번호
	private String user_id; // 회원 id
	private String reply_content; // 댓글내용
	private String reply_date; // 작성일

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reply(int reply_no, int post_no, String user_id, String reply_content, String reply_date) {
		super();
		this.reply_no = reply_no;
		this.post_no = post_no;
		this.user_id = user_id;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	@Override
	public String toString() {
		return "ReplyEntity [reply_no=" + reply_no + ", post_no=" + post_no + ", user_id=" + user_id
				+ ", reply_content=" + reply_content + ", reply_date=" + reply_date + "]";
	}
	
}
