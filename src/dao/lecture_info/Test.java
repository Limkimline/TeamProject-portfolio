package dao.lecture_info;

import java.util.List;

import model.Lecture_Info2;

public class Test {

	public static void main(String[] args) {
		LectureInfoDao dao = new LectureInfoDaoImpl();
		List<Lecture_Info2> lecture_info_list = dao.selectByStartdateEnddateLectureName(3, "2021-11-10", "2022-01-11", "E");
		/*for (Lecture_Info2 lecture_Info2 : lecture_info_list) {
			System.out.println(lecture_Info2.toString());
		}*/
		
		List<Lecture_Info2> lecture_info_list2 = dao.selectMyLectureByLectureNameEnddate2(3, "", "2021-12-10", 1);
	
		for (Lecture_Info2 lecture_Info2 : lecture_info_list2) {
			System.out.println(lecture_Info2.getLectureno());
		}
	}
	

}
