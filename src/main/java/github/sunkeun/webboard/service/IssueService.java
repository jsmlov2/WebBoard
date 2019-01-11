package github.sunkeun.webboard.service;

import java.util.List;
/**
 * 포털별 실시간 이규 키워드를 조회합니다 
 * @author 조선근
 *
 */
public interface IssueService {

	List<String> getIssues(String keyword);

}