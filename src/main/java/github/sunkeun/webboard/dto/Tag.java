package github.sunkeun.webboard.dto;

public class Tag {

	Long seq;
	String tagName;
	
	public Tag(String tagName) {
		this.tagName = tagName;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "Tag [seq=" + seq + ", tagName=" + tagName + "]";
	}
	
	
}
