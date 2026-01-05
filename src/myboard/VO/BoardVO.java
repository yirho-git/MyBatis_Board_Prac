package myboard.VO;

public class BoardVO {
	private int brdNo;			// 게시글 번호
	private String brdTitle;	// 게시글 제목
	private String brdWriter;	// 작성자
	private String brdDate;		// 작성일자
	private String brdContent;	// 작성내용

	public int getBrdNo() {
		return brdNo;
	}
	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}
	
	public String getBrdTitle() {
		return brdTitle;
	}
	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}
	
	public String getBrdWriter() {
		return brdWriter;
	}
	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}
	
	public String getBrdDate() {
		return brdDate;
	}
	public void setBrdDate(String brdDate) {
		this.brdDate = brdDate;
	}

	public String getBrdContent() {
		return brdContent;
	}
	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}
	
	@Override
	public String toString() {
		return brdNo + "\t" + brdTitle + "\t" + brdWriter + "\t"
				+ brdDate + "\t" + brdContent;
	}
}
