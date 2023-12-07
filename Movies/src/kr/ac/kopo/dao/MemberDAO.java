package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.utill.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.MoviesVO;
import kr.ac.kopo.vo.TicketVO;

public class MemberDAO {

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
	
	public int selectById(String memberId) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id ");
		sql.append(" from m_members ");
		sql.append(" where id=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, memberId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<TicketVO> myTicket(String memberid) {
		List<TicketVO> ticketList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, id, title, seat_cnt ");
		sql.append(" from m_ticket ");
		sql.append(" where id=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, memberid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String title = rs.getString("title");
				int seatCnt = rs.getInt("seat_cnt");
				
				TicketVO ticket = new TicketVO(no, id, title, seatCnt);
				ticketList.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticketList;
	}
	
	public int selectMember(String memberId, String memberPass) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password ");
		sql.append(" from m_members ");
		sql.append(" where id=? and password=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int ticketByTitle(String id, String movieTitle) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, title ");
		sql.append(" from m_ticket ");
		sql.append(" where id=? and title=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			pstmt.setString(2, movieTitle);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void signUp(MemberVO member) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into m_members(id, password, name) ");
		sql.append(" values (?, ?, ?) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMember(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from m_members ");
		sql.append(" where id=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertTicket(TicketVO ticket) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into m_ticket(no, id, title, seat_cnt) ");
		sql.append(" values(seq_m_ticket_no.nextval, ?, ?, ?) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, ticket.getId());
			pstmt.setString(2, ticket.getTitle());
			pstmt.setInt(3, ticket.getSeat_cnt());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ticketCancel(String id, String title) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from m_ticket ");
		sql.append(" where id=? and title=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ticketingSeat(int seatCnt, String title) {
		StringBuilder sql = new StringBuilder();
		sql.append("update m_movies ");
		sql.append(" set seatno = seatno - ? ");
		sql.append(" where title = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, seatCnt);
			pstmt.setString(2, title);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int cntSeat(String id, String title) {
		StringBuilder sql = new StringBuilder();
		sql.append("select seat_cnt ");
		sql.append(" from m_ticket ");
		sql.append(" where id=? and title=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			ResultSet rs = pstmt.executeQuery();
			int seat = 0;
			while(rs.next()) {
				seat += rs.getInt("seat_cnt");
			}
			return seat;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int cntSeatMovie(String title) {
		StringBuilder sql = new StringBuilder();
		sql.append("select seatno ");
		sql.append(" from m_movies ");
		sql.append(" where title=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int seat = rs.getInt("seatno");
				return seat;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void cancelSeat(int seatCnt, String title) {
		StringBuilder sql = new StringBuilder();
		sql.append("update m_movies ");
		sql.append(" set seatno = seatno + ? ");
		sql.append(" where title = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setInt(1, seatCnt);
			pstmt.setString(2, title);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MoviesVO> selectByTitle(String movieTitle) {
		List<MoviesVO> list = new ArrayList<MoviesVO>();
		StringBuilder sql = new StringBuilder();
		sql.append("select title, seatno ");
		sql.append(" from m_movies ");
		sql.append(" where title like ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, "%"+movieTitle+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("title");
				int seat = rs.getInt("seatno");
				MoviesVO movie = new MoviesVO();
				movie.setTitle(title);
				movie.setSeatno(seat);
				
				list.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
