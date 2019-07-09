package jcjc.bill.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jcjc.bill.biz.BillBiz;
import jcjc.bill.entity.Bill;
import jcjc.politician.entity.Politician;

@Controller("billController")
public class BillController {

	@Autowired
	BillBiz biz;

	// prediction
	@RequestMapping("/bill/list.do")
	public ModelAndView commitmentPred(HttpSession session) {

		Politician entity = (Politician) session.getAttribute("politician");
		List<Bill> list = biz.selectListBill(entity.getPolitician_no());
		
		return new ModelAndView("bill/list", "billList", list);
	}
	
	
	// graphdata
	@RequestMapping("/bill/graphData.do")
	@ResponseBody
	public Map<String, Object> graphData(@RequestParam("politician_no") int politician_no, HttpSession session){
		Politician politician = (Politician) session.getAttribute("politician");
		
		Map<String, Object> jsonObject = new HashMap<String, Object>(); // ajax에 반환할 객체
		ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
		Map<String, Object> jsonSubObject = null;
		
		jsonSubObject = new HashMap<String, Object>();
		double avg = biz.graphDataAvg();
		jsonSubObject.put("bill", "평균");
		jsonSubObject.put("count", avg);
		jsonList.add(jsonSubObject);
		
		jsonSubObject = new HashMap<String, Object>();
		Integer data = biz.graphDataPolitician(politician_no);
		jsonSubObject.put("bill", politician.getPolitician_kor_name() + " 의원");
		jsonSubObject.put("count", data);
		jsonList.add(jsonSubObject);
		
		jsonObject.put("data", jsonList);
		return jsonObject;
	}
	
}
