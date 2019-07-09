package jcjc.reply.dao;

public interface ReplyDao {
	
	/*
	private int reply_no; // 댓글 번호
	private int post_no; // 게시물 번호
	private String user_id; // 회원 id
	private String reply_content; // 댓글내용
	private String reply_date; // 작성일
	*/
	
	String select_all_post = "select reply_no, post_no, user_id, "
			+ "reply_content, "
			+ "to_char(reply_date, 'yyyy-mm-dd hh24:mi:ss') as reply_date "
			+ "from reply "
			+ "order by reply_no";
			
	String select_list_post = "select reply_no, post_no, user_id, "
			+ "reply_content, "
			+ "to_char(reply_date, 'yyyy-mm-dd hh24:mi:ss') as reply_date "
			+ "from reply "
			+ "where post_no = ? "
			+ "order by reply_no";
	
	String insert_reply = "insert into reply values(seq_reply.nextval, " // reply_no
			+ "?, " // post_no
			+ "?, " // user_id
			+ "?, " // reply_content
			+ "to_date(?, 'yyyy-mm-dd hh24:mi:ss'))"; // reply_date
	
	String update_reply = "update reply set "
			+ "reply_content = ?, "
			+ "reply_date = to_date(?, 'yyyy-mm-dd hh24:mi:ss') "
			+ "where reply_no = ?";
	
	String delete_reply = "delete from reply where reply_no = ?";
	
	String find_reply = "select * from reply where user_id = ?";
	
	String search_reply = "select * from reply "
			+ "where reply_no = ? and "
			+ "user_id = ?";
}