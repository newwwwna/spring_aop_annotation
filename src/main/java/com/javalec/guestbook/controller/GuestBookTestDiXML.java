package com.javalec.guestbook.controller;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.vo.GuestBookVO;

public class GuestBookTestDiXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext container 
		= new GenericXmlApplicationContext("applicationContext.xml") ;
		
		GuestBookController controller 
		= (GuestBookController)container.getBean("guestbook");

		//2. 입력 
		GuestBookVO vo = new GuestBookVO() ;
		vo.setName("홍길동");
		vo.setContent("내용입니다");
		vo.setPassword("1234");
		//controller.add(vo);
		
		//3. 리스트 조회
		List<GuestBookVO> guestlist = controller.getList() ;
		for(GuestBookVO guestbook : guestlist) {
			System.out.println(guestbook.toString());
		}
		
	}

}
