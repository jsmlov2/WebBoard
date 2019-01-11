package github.sunkeun.webboard.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("daum")
public class DaumIssueService extends BaseIssueService implements IssueService {
	
	@Scheduled(cron="*/5 * * * * MON-FRI")
	public List<String> crawling() {
		System.out.println(this.getClass().getName() + " : " + new Date().toString());
		String url = "https://m.search.daum.net/search?w=tot&nil_mtopsearch=btn&DA=YZR&q=test";
		// URLEncoder.encode(s, enc)
		
		Connection con = Jsoup.connect(url);
		Document doc;
		try {
			doc = con.get();
			Elements e = doc.select(".wrap_issue");
			Element issue = e.get(0);
			Elements anchors = issue.select("ol.list_issue > li > a > .txt_issue");
			List<String> keywords = new ArrayList<>();
			for (Element anchor : anchors) {
				// System.out.println(anchor.text());
				keywords.add(anchor.text());
			}
			
			this.keyword.clear();
			this.keyword.addAll(keywords);
			
			return keywords;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
}
