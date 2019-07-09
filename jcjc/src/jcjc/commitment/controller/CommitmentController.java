package jcjc.commitment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jcjc.commitment.biz.CommitmentBiz;
import jcjc.commitment.entity.Commitment;
import jcjc.commitment.entity.CommitmentEntity;
import jcjc.politician.entity.Politician;

@Controller("commitmentController")
public class CommitmentController {

	@Autowired
	private CommitmentBiz biz;
	
	// all
	@RequestMapping("/commitment/all.do")
	public ModelAndView commitmentAll() {
		List<Commitment> all = biz.selectAllCommitment();
		return new ModelAndView("commitment/all", "all", all);
		
	}
	
	// list + commitment avg
	@RequestMapping("/commitment/list.do")
	public ModelAndView commitmentList(HttpSession session) {
		Politician entity = (Politician) session.getAttribute("politician");
		
		List<CommitmentEntity> list = biz.selectListCommitmentAddAvg(entity);
		
		ModelAndView mav = new ModelAndView("commitment/list", "commitmentList", list);
		
		return mav;
	}
	
	   // prediction
	@ResponseBody
	@RequestMapping("/commitment/pred.do")
	   public ModelAndView commitmentPred(HttpSession session) {
	      
		  Politician entity = (Politician) session.getAttribute("politician");
	      List<Commitment> list = biz.selectListCommitment(entity);
	      
	      return new ModelAndView("commitment/pred", "commitmentList", list);
	   }
	
	
	
	// graphdata
	@RequestMapping("/commitment/graphData.do")
	@ResponseBody
	public Map<String, Object> graphData(@RequestParam("politician_no") int politician_no) {
		Map<String, Object> jsonObject = new HashMap<String, Object>(); // ajax에 반환할 객체
		ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
		Map<String, Object> jsonSubObject = null;
		Integer data = null;
		
		jsonSubObject = new HashMap<String, Object>();
		data = biz.graphData(politician_no, "이행");
		jsonSubObject.put("commitment", "이행");
		jsonSubObject.put("count", data);
		jsonList.add(jsonSubObject);
		
		jsonSubObject = new HashMap<String, Object>();
		data = biz.graphData(politician_no, "진행");
		jsonSubObject.put("commitment", "진행");
		jsonSubObject.put("count", data);
		jsonList.add(jsonSubObject);
		
		jsonSubObject = new HashMap<String, Object>();
		data = biz.graphData(politician_no, "미이행");
		jsonSubObject.put("commitment", "미이행");
		jsonSubObject.put("count", data);
		jsonList.add(jsonSubObject);
		
		jsonObject.put("data", jsonList);
		return jsonObject;
	}
	
}
