package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.MoviesVO;
import kr.ac.kopo.vo.TicketVO;

public class MemberService {

	private MemberDAO dao;
	
	public MemberService() {
		dao = new MemberDAO();
	}
	
	public List<MoviesVO> selectMovies(){
		List<MoviesVO> list = dao.selectAll();
		return list;
	}
	
	public void signUp(MemberVO member) {
		dao.signUp(member);
	}
	
	public int selectById(String id) {
		int cnt = dao.selectById(id);
		return cnt;
	}
	
	public int ticketByTitle(String id, String title) {
		int cnt = dao.ticketByTitle(id, title);
		return cnt;
	}
	
	public List<TicketVO> myTicket(String id){
		List<TicketVO> ticketList = dao.myTicket(id);
		return ticketList;
	}
	
	public int selectMember(String id, String pass) {
		int cnt = dao.selectMember(id, pass);
		return cnt;
	}
	
	public void Cancel(String id) {
		dao.deleteMember(id);
	}
	
	public void ticketing(TicketVO ticket, int seat, String title) {
		dao.insertTicket(ticket);
		dao.ticketingSeat(seat, title);
	}
	
	public void ticketCancel(String id, String title) {
		int seat = dao.cntSeat(id, title);
		dao.ticketCancel(id, title);
		dao.cancelSeat(seat, title);
	}
	
	public int countSeat(String title) {
		int cnt = dao.cntSeatMovie(title);
		return cnt;
	}
	
	public List<MoviesVO> searchTitle(String title){
		List<MoviesVO> list = dao.selectByTitle(title);
		return list;
	}
}
