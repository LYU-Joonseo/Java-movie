package kr.ac.kopo.manager.ui;

import kr.ac.kopo.member.ui.BaseUI;
import kr.ac.kopo.service.ManagerService;
import kr.ac.kopo.vo.MoviesVO;

public class InsertMoviesUI extends BaseUI{

	private ManagerService service;
	
	public InsertMoviesUI() {
		service = new ManagerService();
	}
	
	public void execute() throws Exception{
		String title = scanStr("상영하려는 영화 제목을 입력하세요: ");
		
		MoviesVO movies = new MoviesVO();
		movies.setTitle(title);
		
		service.insertMovie(movies);
		
		System.out.println("상영중인 영화가 등록되었습니다.\n");
	}
}
