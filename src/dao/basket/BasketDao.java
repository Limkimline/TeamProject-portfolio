package dao.basket;

import java.util.List;

import model.Basket;
import model.Lecture;


public interface BasketDao {
		
	void insert(Basket basket);

	void delete(int userno, int lectureno);
	
	List<Lecture> selectByUserno(int userno);
	
	void deleteDate(int userno);
	
	List<Lecture> selectByUserno(int userno, int reqPage);
}
