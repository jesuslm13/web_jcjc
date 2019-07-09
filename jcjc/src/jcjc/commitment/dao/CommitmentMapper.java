package jcjc.commitment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import jcjc.commitment.entity.Commitment;
import jcjc.commitment.entity.CommitmentEntity;
import jcjc.politician.entity.Politician;

public interface CommitmentMapper {
	
	@Select("select "
			+ "commitment_no, "
			+ "politician_no, "
			+ "to_char(commitment_proposal_date, 'yyyy-mm-dd') as commitment_proposal_date, "
			+ "commitment_title, "
			+ "commitment_content, "
			+ "commitment_fulfillment "
			+ "from commitment "
			+ "order by commitment_no"
			)
	List<Commitment> selectAllCommitment();

	@Select("select "
			+ "commitment_no, "
			+ "politician_no, "
			+ "to_char(commitment_proposal_date, 'yyyy-mm-dd') as commitment_proposal_date, "
			+ "commitment_title, "
			+ "commitment_content, "
			+ "commitment_fulfillment "
			+ "from commitment "
			+ "where politician_no = #{politician_no} "
			+ "order by commitment_no"
			)
	List<Commitment> selectListCommitment(Politician politician);
	
	@Select("select "
			+ "count(commitment_no) as count "
			+ "from commitment "
			+ "where politician_no = #{politician_no} "
			+ "and commitment_fulfillment = #{commitment_fulfillment}")
	int graphData(@Param("politician_no") int politician_no, @Param("commitment_fulfillment") String commitment_fulfillment);
	
	
	

}
