package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Lecture_Qna {
	private int qnano;
	private String subject;
	private String content;
	private String answer;
	private AtomicInteger clickCount;
	private String open;
	private String writeDate;
	private int userno;
	private int lectureno;
	
	
	
	


	@Override
	public String toString() {
		return "Lecture_Qna [qnano=" + qnano + ", subject=" + subject + ", content=" + content + ", answer=" + answer
				+ ", clickCount=" + clickCount + ", open=" + open + ", writeDate=" + writeDate + ", userno=" + userno
				+ ", lectureno=" + lectureno + "]";
	}
	public AtomicInteger getClickCount() {
		return clickCount;
	}
	public void setClickCount(AtomicInteger clickCount) {
		this.clickCount = clickCount;
	}
	public int getQnano() {
		return qnano;
	}
	public void setQnano(int qnano) {
		this.qnano = qnano;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public int getLectureno() {
		return lectureno;
	}
	public void setLectureno(int lectureno) {
		this.lectureno = lectureno;
	}

	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	
	
	
}
