package jcjc.post.dao;

public interface PostDao {
	
	/*
	private int post_no; // 게시물 번호
	private int commitment_no; // 공약번호
	private String user_id; // 작성자 id
	private int post_score; // 별점
	private String post_title; // 게시물 제목
	private String post_content; // 게시물 내용
	private String post_date; // 작성일
	*/
	
	String select_all_post = "select post_no, commitment_no, user_id, "
						+ "post_score, post_title, post_content, "
						+ "to_char(post_date, 'yyyy-mm-dd hh24:mi:ss') as post_date "
						+ "from post "
						+ "order by post_no";
	
	String select_list_post = "select post_no, commitment_no, user_id, "
						+ "post_score, post_title, post_content, "
						+ "to_char(post_date, 'yyyy-mm-dd hh24:mi:ss') as post_date "
						+ "from post "
						+ "where commitment_no = ? "
						+ "order by post_no";			
	
	String insert_post = "insert into post values(seq_post.nextval, " // post_no
						+ "?, " // commitment_no
						+ "?, " // user_id
						+ "?, " // post_score
						+ "?, " // post_title
						+ "?, " // post_content
						+ "to_date(?, 'yyyy-mm-dd hh24:mi:ss'))"; // post_date
	
	String delete_post = "delete from post where post_no = ?";
	
	String update_post = "update post set "
						+ "post_score = ?, "
						+ "post_title = ?, "
						+ "post_content = ?, "
						+ "post_date = to_date(?, 'yyyy-mm-dd hh24:mi:ss') "
						+ "where post_no = ?";
	
	String find_post = "select * from post where user_id = ?";
	
	String search_post = "select * from post where post_no = ? and user_id = ?";
	
	String detail_post = "select * from post where post_no = ?";
	
	String avg_score_post = "select round(nvl(avg(post_score), 0), 2) as avg_score "
						+ "from post "
						+ "where commitment_no = ?";
}
