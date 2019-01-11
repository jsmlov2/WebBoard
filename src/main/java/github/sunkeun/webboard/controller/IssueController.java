package github.sunkeun.webboard.controller;

import java.util.Arrays;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import github.sunkeun.webboard.service.DaumIssueService;
import github.sunkeun.webboard.service.IssueService;
import github.sunkeun.webboard.service.NaverIssueService;

@Controller
public class IssueController {

	@Inject DaumIssueService daum;
	@Inject NaverIssueService naver;
	
	@RequestMapping(value="/issues/{portal}", method=RequestMethod.GET, produces="application/json; charset=utf-8")
	@ResponseBody
	public Object issue(@PathVariable String portal) {
		return daum.getIssues("");
//		return Arrays.asList("a", "B");
	}
}
