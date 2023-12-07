package kr.ac.kopo.manager.ui;

import kr.ac.kopo.member.ui.BaseUI;
import kr.ac.kopo.service.ManagerService;

public class DeleteAllMoviesUI extends BaseUI{

	private ManagerService service;
	
	public DeleteAllMoviesUI() {
		service = new ManagerService();
	}
	
	public void execute() throws Exception{
		System.out.println("영화 전체 삭제를 진행합니다.");
		String answer = scanStr("전체삭제를 진행할까요? (Y/N): ");
		switch (answer) {
		case "Y":
			service.deleteAllMovies();
			System.out.println("삭제를 완료하였습니다.\n");
			break;
		case "y":
			service.deleteAllMovies();
			System.out.println("삭제를 완료하였습니다.\n");
			break;
		case "N":
			System.out.println("전체 삭제를 취소하였습니다.");
			System.out.println("메뉴로 돌아갑니다.\n");
			break;
		case "n":
			System.out.println("전체 삭제를 취소하였습니다.");
			System.out.println("메뉴로 돌아갑니다.\n");
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			System.out.println("전체 삭제를 종료합니다.\n");
			break;
		}
	}
}
