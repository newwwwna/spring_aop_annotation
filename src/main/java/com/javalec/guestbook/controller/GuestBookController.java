package com.javalec.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.javalec.common.Log4Advice;
import com.javalec.common.LogAdvice;
import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.dao.GuestBookDSDAO;
import com.javalec.guestbook.vo.GuestBookVO;



@Component("guestbook")
public class GuestBookController {

	@Autowired
	private GuestBookDAO guestbookDao ;


	
	public void setGuestbookDao(GuestBookDAO guestbookDao) {
		this.guestbookDao = guestbookDao;
	}

	public List<GuestBookVO> getList(){
		List<GuestBookVO> list = guestbookDao.getList();
	
	
		return list ;
	}
	
	public void delete(GuestBookVO vo) {
		guestbookDao.delete(vo);
	}
	
	public void add(GuestBookVO vo) {
		guestbookDao.insert(vo);
	}
}
