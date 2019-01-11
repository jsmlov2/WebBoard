package github.sunkeun.webboard.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class IssueServiceTest {

	@Test
	public void test() {
		NaverIssueService nis = new NaverIssueService();
		List<String> kwd = nis.getIssues("");
		assertTrue(kwd.size() > 0 );
		System.out.println(kwd);
		
		
	}

}
