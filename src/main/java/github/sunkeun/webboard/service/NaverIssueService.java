package github.sunkeun.webboard.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class NaverIssueService implements IssueService{

	@Override
	public List<String> getIssues(String keyword) {
		// 네이버 실시간 이규 긁어옴
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
			
			return keywords;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
