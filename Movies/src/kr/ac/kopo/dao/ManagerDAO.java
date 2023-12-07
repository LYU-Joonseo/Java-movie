package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import kr.ac.kopo.utill.ConnectionFactory;
import kr.ac.kopo.vo.ManagerVO;
import kr.ac.kopo.vo.MoviesVO;

public class ManagerDAO {

	public ManagerVO login(ManagerVO manager) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from m_manager ");
		sql.append(" where id = ? and password = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, manager.getId());
			pstmt.setString(2, manager.getPass());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				String pass = rs.getString("password");
				
				ManagerVO log = new ManagerVO(id, pass);
				return log;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<MoviesVO> selectAll() {
		
		List<MoviesVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from m_movies ");
		sql.append(" order by no desc ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				int seatno = rs.getInt("seatno");
				
				MoviesVO movies = new MoviesVO(no, title, seatno);
				list.add(movies);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int selectByTitle(String movieTitle) {
		StringBuilder sql = new StringBuilder();
		sql.append("select title ");
		sql.append(" from m_movies ");
		sql.append(" where title=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, movieTitle);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void insertMovie(MoviesVO movies) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into m_movies(no, title) ");
		sql.append(" values (seq_m_movies_no.nextval, ?) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, movies.getTitle());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMovie(String title) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from m_movies ");
		sql.append(" where title=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, title);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllMovies() {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from m_movies ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {	
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
