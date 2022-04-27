package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {

	 private Connection conn;
	 private ResultSet rs;

	 public BbsDAO() {
	  try {
	   String dbURL = "jdbc:mysql://localhost:3306/TEST?useSSL=false"; //본인 컴퓨터의 주소, 데이터베이스에 접근
	   String dbID = "root";
	   String dbPassword = "root"; //자기 비밀번호 넣어주기
	   Class.forName("com.mysql.jdbc.Driver");
	   conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	 }

	public String getDate() { //현재 서버의 시간
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ""; //데이터베이스 오류
	}
	
	public int getNext() { 
		String SQL = "SELECT bbsID FROM bbs ORDER BY bbsID DESC";
		try {//제일 마지막에 쓰인 결과를 가져옴
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1; // 그다음 게시글이 만들어질 수 있도록 결과 반환
			}
			return 1;//첫번째 게시글인 경우
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	
	public int write(String bbsTitle, String userID, String bbsContent) { 
		String SQL = "INSERT INTO bbs VALUES (?,?,?,?,?,?)";
		try {//제일 마지막에 쓰인 결과를 가져옴
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate(); //0이상의 결과
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	
	public ArrayList<Bbs> getList(int pageNumber){
		String SQL = "SELECT * FROM bbs WHERE bbsID < ? AND bbsAvailable =1 ORDER BY bbsID DESC LIMIT 10";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {//제일 마지막에 쓰인 결과를 가져옴
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber -1)*10);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean nextPage(int pageNumber) {//페이징 처리
		String SQL = "SELECT * FROM bbs WHERE bbsID < ? AND bbsAvailable = 1";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber -1)*10);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//특정한 아이디에 해당하는 글 하나를 가져온다.
	public Bbs getBbs(int bbsID) {
		String SQL = "SELECT * FROM bbs WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				return bbs;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;//해당 글이 존재하지 않을 때
	}
	public int update(int bbsID, String bbsTitle, String bbsContent) {
		String SQL = "UPDATE bbs SET bbsTitle =?, bbsContent = ? WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, bbsTitle);
			pstmt.setString(2, bbsContent);
			pstmt.setInt(3, bbsID);
			return pstmt.executeUpdate(); //0이상의 결과
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	
	public int delete(int bbsID) {
		String SQL = "UPDATE bbs SET bbsAvailable = 0 WHERE bbsID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			return pstmt.executeUpdate(); //0이상의 결과
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	
	
	
}