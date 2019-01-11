package github.sunkeun.webboard.service;

import java.util.ArrayList;
import java.util.List;

public class BaseIssueService implements IssueService{

	protected List<String> keyword = new ArrayList<>();

	public BaseIssueService() {
		super();
	}

	public List<String> getKeywords() {
		synchronized (this.keyword) {
			return keyword;
		}
	}

}