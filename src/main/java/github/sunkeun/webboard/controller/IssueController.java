package github.sunkeun.webboard.controller;

import java.util.Arrays;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import github.sunkeun.webboard.service.BaseIssueService;
import github.sunkeun.webboard.service.DaumIssueService;
import github.sunkeun.webboard.service.IssueService;

@Controller
public class IssueController {

	@Resource(name="daum") DaumIssueService daum;
	@Resource(name="naver") BaseIssueService naver;
	
	@RequestMapping(value="/issues/{portal}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	@ResponseBody
	public Object issue(@PathVariable String portal) {
		HashMap<String, Object> res = new HashMap<>();
		if(portal.equals("naver")) {
			res.put("success", true);
			res.put("data", naver.getKeywords());
		}else if(portal.equals("daum")){
			res.put("success",true);
			res.put("data", daum.getKeywords());
		}else {
			res.put("success", false);
			res.put("cause", "NO_SUCH_PORTAL");
		}
		return res;
		
//		return Arrays.asList("a", "B");
	}
}
