package github.sunkeun.webboard.jsoup;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class TestJsoup {

	@Test
	public void test() throws IOException {
		Connection con = Jsoup.connect("https://m.search.daum.net/search?w=tot&nil_mtopsearch=btn&DA=YZR&q=%EA%B0%90%EC%9E%90%ED%83%95");
		Document doc = con.get();
		Elements e = doc.select(".wrap_issue");
		Element issue = e.get(0);
		Elements anchors = issue.select("ol.list_issue > li > a > .txt_issue");
		for (Element anchor : anchors) {
			System.out.println(anchor.text());
		}
		//System.out.println(issue.toString());
		// System.out.println(doc.toString());
	}

}
