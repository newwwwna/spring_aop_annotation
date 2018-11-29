package com.javalec.guestbook.controller;

import java.util.List;

import com.javalec.guestbook.dao.GuestBookDAO;
import com.javalec.guestbook.dao.GuestBookDSDAO;
import com.javalec.guestbook.vo.GuestBookVO;

public class GuestBookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuestBookController controller = new GuestBookController();
		// 1. 컨트롤러에 dao 객체 세팅
		GuestBookDAO dao = new GuestBookDAO();
		controller.setGuestbookDao(dao);

		// 2. 입력

		GuestBookVO vo = new GuestBookVO();
		vo.setName("홍길동");
		vo.setContent("내용입니다");
		vo.setPassword("1234");
	//	controller.add(vo);

		// 3. 리스트 조회
		List<GuestBookVO> guestlist = controller.getList();
		for (GuestBookVO guestbook : guestlist) {
			System.out.println(guestbook.toString());
		}

	}

}
