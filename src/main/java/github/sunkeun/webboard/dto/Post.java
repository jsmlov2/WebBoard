package github.sunkeun.webboard.dto;
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
	// User writer;
	
	
	
	
	public Post() {
		super();
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
	
	
}
