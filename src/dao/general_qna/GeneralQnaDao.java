
package dao.general_qna;

import java.util.List;
import model.General_Qna;
public interface GeneralQnaDao {
	void GeneralQnaInsert(General_Qna gq  );
	void GeneralQnaInsertByNoMember(General_Qna gq  );
	
	List<General_Qna> GeneralQnaSearchAll();

	General_Qna GeneralQnaSelectByQnaNo(int qnaNo);
	
	List<General_Qna> selectAllToPage( int requestPage );
	List<General_Qna> selectByUsernoToPage( int requestPage, int userno );
	List<General_Qna> selectBySubjectToPage( int requestPage, String subject );
	
	
	
	
	
	void GeneralQnaUpdateByQnaNo(General_Qna gq);

	void GeneralQnaDeleteByQnano(int qnano);
	
	
	int GeneralQnaCntAll();
	int GeneralQnaCntByUserno(int userno);
	int GeneralQnaCntBySubject(String subject);
	
	void updateClickCount(General_Qna gq);
	
}
