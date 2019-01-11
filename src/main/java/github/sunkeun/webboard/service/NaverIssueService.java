package github.sunkeun.webboard.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("naver")
public class NaverIssueService extends BaseIssueService implements IssueService{

	/*
	 *   Runnable r = new Runnable() {
	 *      public void run() {
	 *      
	 *          naverService.getIssue();
	 *      }
	 *   }
	 *   
	 *   new Thread(r).start();
	 *   
	 *   
	 *   
	 */
	@Scheduled(cron="0/5 * * * * MON-FRI")
	public List<String> crawling() {
		// 네이버 실시간 이규 긁어옴
		
		System.out.println(this.getClass().getName() + " : " + new Date().toString());
		String url = "https://m.search.naver.com/search.naver?query=test&where=m&sm=mtp_hty";
		
		Connection con = Jsoup.connect(url);
		con.header("referrer", "https://m.naver.com/");
		
		Document doc;
		try {
			doc = con.get();
			// System.out.println(doc.toString());
			
			Elements kwd = doc.select(".hotkwd"); // .hotkwd > ol > li > a .tit
			Element k0 = kwd.get(0);
			Elements anchors = k0.select("ol > li > a .tit");
			List<String> keywords = new ArrayList<>();
			for (Element anchor : anchors) {
				// System.out.println(anchor.text());
				keywords.add(anchor.text());
			}
			
			synchronized (this.keyword) {
				this.keyword.clear();   // 1)
				this.keyword.addAll(keywords); // 3)				
			}
			
			return keywords;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
