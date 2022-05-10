package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.BoardVO;
import util.DBManager;

public class BoardDAO extends DBManager {
	private BoardDAO() {
	}
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> selectAllBoards(){
		String sql = " SELECT * FROM board ORDER BY num DESC";
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setWriterDate(rs.getTimestamp("writerDate"));
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, rs);
		}
		return list;
	}
	
	public void insertBoard(BoardVO bVo) {
		String sql = "INSERT INTO board(title, content, writer, writerDate)"
				+ "VALUES (?, ?, ?, now())";
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bVo.getTitle());
			stmt.setString(2, bVo.getContent());
			stmt.setString(3, bVo.getWriter());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	}
	
	public void updateBoard(BoardVO bVo) {
		String sql = "UPDATE board SET title = ?, content = ?, writer = ? WHERE num = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bVo.getTitle());
			stmt.setString(2, bVo.getContent());
			stmt.setString(3, bVo.getWriter());
			stmt.setInt(4, bVo.getNum());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	}
	
	//게시판 글 상세내용보기 :글번호로 찾아오기, 실패=null
	public BoardVO selectOneBoardByNum(String num) {
		String sql = "SELECT * FROM board WHERE num = ?";
		BoardVO bVo = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, num);
			rs = stmt.executeQuery();
			if(rs.next()) {
				bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWriter(rs.getString("writer"));
				bVo.setWriterDate(rs.getTimestamp("writerDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, rs);
		}
		return bVo;
	}
	
	public void deleteBoard(String num) {
		String sql = "DELETE FROM board WHERE num = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
		conn = getConn();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, num);
		stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	}
}
