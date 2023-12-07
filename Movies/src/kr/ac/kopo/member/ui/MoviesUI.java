package kr.ac.kopo.member.ui;

import kr.ac.kopo.manager.ui.ManagerLoginUI;
import kr.ac.kopo.ui.ExitUI;
import kr.ac.kopo.ui.IMoviesUI;
import kr.ac.kopo.ui.SelectMovieUI;

public class MoviesUI extends BaseUI {

	private String menu() {
		System.out.println("\t< 영화관 메뉴 >");
		System.out.println("1. 상영중인 영화 조회");
		System.out.println("2. 상영중인 영화 검색");
		System.out.println("3. 예매한 영화 조회");
		System.out.println("4. 영화 예매");
		System.out.println("5. 영화 예매 취소");
		System.out.println("6. 회원 가입");
		System.out.println("7. 회원 탈퇴");
		System.out.println("8. 관리자 전환");		
		System.out.println("0. 종료");
		
		String menu = scanStr("원하는 메뉴를 고르세요. ");
		return menu;
	}
	
	public void execute() throws Exception{
		while(true){
			IMoviesUI ui = null;
			String menu = menu();
			
			switch (menu) {
			case "1":
				ui = new SelectMovieUI();
				break;
			case "2":
				ui = new SearchMovie();
				break;
			case "3":
				ui = new SelectMyUI();
				break;
			case "4":
				ui = new TicketingUI();
				break;
			case "5":
				ui = new TicketCancelUI();
				break;
			case "6":
				ui = new SignUpUI();
				break;
			case "7":
				ui = new CancelUI();
				break;
			case "8":
				ui = new ManagerLoginUI();
				break;
			case "0":
				ui = new ExitUI();
				break;
			}
			if (ui != null) {
				ui.execute();
			}else {
				System.out.println("입력하신 메뉴는 존재하지 않습니다.\n");
			}
		}
	}
}
