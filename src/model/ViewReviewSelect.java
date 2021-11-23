package model;

public class ViewReviewSelect {
	private String id;
	private String content;
	private double score;
	private String writeDate;
	
	
	
	
	
	@Override
	public String toString() {
		return "ViewReviewSelect [id=" + id + ", content=" + content + ", score=" + score + ", writeDate=" + writeDate
				+ "]";
	}
	
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
	
}
