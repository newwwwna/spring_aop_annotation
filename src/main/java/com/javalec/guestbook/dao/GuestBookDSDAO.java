package com.javalec.guestbook.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.stereotype.Component;

import com.javalec.guestbook.vo.GuestBookVO;


@Component("dsdao")
public class GuestBookDSDAO {
	
	private DataSource ds;

//		private Connection getConnection() {
//			Connection conn = null;
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				String url = "jdbc:oracle:thin:@localhost:1521:xe";
//				conn = DriverManager.getConnection(url, "scott", "tiger");
//			} catch (ClassNotFoundException e) {
//				System.out.println("class없음");
//			} catch (SQLException e) {
//				System.out.println("SQL 오류");
//			}
//			return conn;
//		}

		public int insert(GuestBookVO vo) {
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ds.getConnection();
				String sql = "INSERT INTO GUESTBOOK VALUES(guestbook_seq.nextval,?,?,?,SYSDATE)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getPassword());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
		}

		public int delete(GuestBookVO vo) {

			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = ds.getConnection();
				String sql = "DELETE FROM GUESTBOOK WHERE NO=? AND PASSWORD=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, vo.getNo());
				pstmt.setString(2, vo.getPassword());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;

		}

		public GuestBookVO getGuestBook(GuestBookVO vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			GuestBookVO resultVO = new GuestBookVO();

			try {
				conn = ds.getConnection();
				String sql = "SELECT NO, NAME, CONTENT, PASSWORD, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') WHERE NO=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, vo.getNo());
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Long guestNo = rs.getLong(1);
					String name = rs.getString(2);
					String content = rs.getString(3);
					String password = rs.getString(4);
					String reg_date = rs.getString(5);

					resultVO.setNo(guestNo);
					resultVO.setName(name);
					resultVO.setContent(content);
					resultVO.setPassword(password);
					resultVO.setRegDate(reg_date);
				}
			} catch (SQLException e) {

			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return vo;
		}

		public List<GuestBookVO> getGuestBookList() {
			List<GuestBookVO> list = new ArrayList<GuestBookVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = ds.getConnection();
				String sql = "select no, name, content, password, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') from guestbook order by reg_date desc";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					GuestBookVO vo = new GuestBookVO();
					Long no = rs.getLong(1);
					String name = rs.getString(2);
					String content = rs.getString(3);
					String password = rs.getString(4);
					String reg_date = rs.getString(5);

					vo.setNo(no);
					vo.setName(name);
					vo.setContent(content);
					vo.setPassword(password);
					vo.setRegDate(reg_date);
					list.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		}

		public int update(GuestBookVO vo) {
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn=ds.getConnection();
				String sql = "UPDATE GUESTBOOK SET NAME=?, CONTENT=?, PASSWORD=?, REG_DATE=SYSDATE WHERE NO=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getPassword());
				pstmt.setLong(4, vo.getNo());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}

			return result;
		}
	}


