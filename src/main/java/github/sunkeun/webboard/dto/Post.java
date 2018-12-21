package github.sunkeun.webboard.dto;

import java.util.List;

/**
 * 
 * careate table (
 *   seq int Primary Key 
 *   title varchar,
 *   content varchar,
 *   
 * )
 * @author 조선근
 *
 */
public class Post {
	Integer seq; // PK
	String title;
	String content;
	List<String> tags;
	Member writer;
	
	
	public Post() {
		super();
	}
	
	public Post(Integer seq, String title, String content, List<String> tags, Member writer) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.tags = tags;
		this.writer = writer;
	}

	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public Post(Integer seq, String t, String c) {
		this.seq= seq;
		title = t;
		content = c;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Member getWriter() {
		return writer;
	}
	public void setWriter(Member writer) {
		this.writer = writer;
	}
	
	
	
	
}
