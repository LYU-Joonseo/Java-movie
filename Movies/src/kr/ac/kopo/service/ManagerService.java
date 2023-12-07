package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.ManagerDAO;
import kr.ac.kopo.vo.ManagerVO;
import kr.ac.kopo.vo.MoviesVO;

public class ManagerService {

	private ManagerDAO dao;
	
	public ManagerService() {
		dao = new ManagerDAO();
	}
	
	public ManagerVO login(ManagerVO manager) {
		ManagerVO log = dao.login(manager);
		return log;
	}
	
	public void insertMovie(MoviesVO movies) {
		dao.insertMovie(movies);
	}
	
	public List<MoviesVO> selectAll(){
		List<MoviesVO> list = dao.selectAll();
		return list;
	}
	
	public int selectByTitle(String title) {
		int cnt = dao.selectByTitle(title);
		return cnt;
	}
	
	public void deleteMovie(String title) {
		dao.deleteMovie(title);
	}
	
	public void deleteAllMovies() {
		dao.deleteAllMovies();
	}
}
