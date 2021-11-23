package dao.general_qna;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.General_Qna;

public class Test {
public static void main(String[] args) {
	General_Qna gq = new General_Qna();
	
	gq.setSubject("테스트1024");
	gq.setContent("테스트 테스트 1024");
	gq.setOpen("1");
	gq.setManagerno(1);
	gq.setUserno(1);
	
	GeneralQnaDao generalQnaDao = new GeneralQnaDaoImpl();
	generalQnaDao.GeneralQnaInsert(gq);
	

	}
}
