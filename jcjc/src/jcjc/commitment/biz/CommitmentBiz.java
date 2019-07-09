package jcjc.commitment.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcjc.commitment.dao.CommitmentDaoImpl;
import jcjc.commitment.entity.Commitment;
import jcjc.commitment.entity.CommitmentEntity;
import jcjc.politician.entity.Politician;
import jcjc.post.dao.PostDaoImpl;
import jcjc.post.entity.Post;

@Service("commitmentBiz")
public class CommitmentBiz {

	@Autowired
	private CommitmentDaoImpl dao;
	@Autowired
	private PostDaoImpl post_dao;
	
	public List<Commitment> selectAllCommitment() {
		return dao.selectAllCommitment();
	}
	
	public List<CommitmentEntity> selectListCommitmentAddAvg(Politician politician) {
		
		List<Commitment> list_commitment_vo = dao.selectListCommitment(politician);
		List<CommitmentEntity> list_entity = new ArrayList<CommitmentEntity>();
		
		for(Commitment commitment : list_commitment_vo) {
			
			Double commitment_avg = post_dao.selectCommitmentAvg(commitment.getCommitment_no());
			CommitmentEntity commitmentEntity = new CommitmentEntity();
			
				commitmentEntity.setCommitment_no(commitment.getCommitment_no());
				commitmentEntity.setPolitician_no(commitment.getPolitician_no());
				commitmentEntity.setCommitment_proposal_date(commitment.getCommitment_proposal_date());
				commitmentEntity.setCommitment_title(commitment.getCommitment_title());
				commitmentEntity.setCommitment_content(commitment.getCommitment_content());
				commitmentEntity.setCommitment_fulfillment(commitment.getCommitment_fulfillment());
				commitmentEntity.setCommitment_avg(commitment_avg);
			
			list_entity.add(commitmentEntity);
		}
		
		return list_entity;
	}
	
   public List<Commitment> selectListCommitment(Politician politician) {
	   
	   return dao.selectListCommitment(politician);
   }
	
	public int graphData(int politician_no, String commitment_fulfillment) {
		return dao.graphData(politician_no, commitment_fulfillment);
	}
}
