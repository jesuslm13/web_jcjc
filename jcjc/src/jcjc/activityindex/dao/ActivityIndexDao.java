package jcjc.activityindex.dao;

public interface ActivityIndexDao {

	String select_activity_index = "select committee_name, count(*) as count "
			+ "from bill "
			+ "where politician_no=? "
			+ "and rownum <= 8 "
			+ "group by committee_name "
			+ "order by count desc";

}
