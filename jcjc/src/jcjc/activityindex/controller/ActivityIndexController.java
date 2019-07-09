package jcjc.activityindex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jcjc.activityindex.biz.ActivityIndexBiz;

@Controller("activityIndexController")
public class ActivityIndexController {

	@Autowired
	ActivityIndexBiz biz;
	
	@RequestMapping("/activity/score.do")
	public ModelAndView showActivityIndex(@RequestParam("politician_no")int politician_no, HttpSession session){
		Map<String, Object> jsonObject = new HashMap<String, Object>(); // ajax에 반환할 객체
		List<Map<String, Object>> jsonList = biz.graphData(politician_no);
		
		jsonObject.put("data", jsonList);
		session.setAttribute("activity_list", jsonList);
		
		return new ModelAndView("politician/activity", "activity_list", jsonList);
	}
	
	
	// graphdata
		@RequestMapping("/activity/graphData.do")
		@ResponseBody
		public Map<String, Object> graphData(@RequestParam("politician_no") int politician_no) {
			Map<String, Object> jsonObject = new HashMap<String, Object>(); // ajax에 반환할 객체
			List<Map<String, Object>> jsonList = biz.graphData(politician_no);
			
			jsonObject.put("data", jsonList);
			return jsonObject;
		}
}
