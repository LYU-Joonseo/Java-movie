package kr.ac.kopo.manager.ui;

import kr.ac.kopo.member.ui.BaseUI;
import kr.ac.kopo.member.ui.MoviesUI;
import kr.ac.kopo.service.ManagerService;
import kr.ac.kopo.ui.ExitUI;
import kr.ac.kopo.ui.IMoviesUI;
import kr.ac.kopo.ui.SelectMovieUI;

public class ManagerUI extends BaseUI{

	private ManagerService service;
	
	public ManagerUI() {
		service = new ManagerService();
	}

	private String managerMenu() {
		System.out.println("\t< 관리자 메뉴 >");
		System.out.println("1. 상영중인 영화 조회");
		System.out.println("2. 상영중인 영화 추가");
		System.out.println("3. 상영중인 영화 삭제");
		System.out.println("4. 상영중인 영화 전체 삭제");
		System.out.println("5. 관리자 로그아웃");
		System.out.println("0. 시스템 종료");
		
		String menu = scanStr("원하는 메뉴를 입력하세요 : ");
		return menu;
	}
	
	@Override
	public void execute() throws Exception {
		while(true) {
			IMoviesUI ui = null;
			String menu = managerMenu();
			
			switch (menu) {
			case "1":
				ui = new SelectMovieUI();
				break;
			case "2":
				ui = new InsertMoviesUI();
				break;
			case "3":
				ui = new DeleteMoviesUI();
				break;
			case "4":
				ui = new DeleteAllMoviesUI();
				break;
			case "5":
				ui = new MoviesUI();
				break;
			case "0":
				ui = new ExitUI();
				break;
			}
			if(ui != null) {
				ui.execute();
			}else {
				System.out.println("메뉴를 잘못 입력하였습니다.\n");
			}
		}
	}
}
