package model;

public class Lecture_Info2 {
	private int infono;
	private double progress;
	private double attendance;
	private int userno;
	private int lectureno;
	private Lecture lecture;
	
	public Lecture_Info2() {}
	
	

	public Lecture_Info2(int infono, double progress, double attendance, int userno, int lectureno, Lecture lecture) {
		super();
		this.infono = infono;
		this.progress = progress;
		this.attendance = attendance;
		this.userno = userno;
		this.lectureno = lectureno;
		this.lecture = lecture;
	}

	


	@Override
	public String toString() {
		return "Lecture_Info2 [infono=" + infono + ", progress=" + progress + ", attendance=" + attendance + ", userno="
				+ userno + ", lectureno=" + lectureno + ", lecture=" + lecture + "]";
	}



	public int getInfono() {
		return infono;
	}
	public void setInfono(int infono) {
		this.infono = infono;
	}
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}
	public double getAttendance() {
		return attendance;
	}
	public void setAttendance(double attendance) {
		this.attendance = attendance;
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


	public Lecture getLecture() {
		return lecture;
	}


	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
	
	
	
}
