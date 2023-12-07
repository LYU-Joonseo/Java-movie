package kr.ac.kopo.manager.ui;

import kr.ac.kopo.member.ui.BaseUI;
import kr.ac.kopo.service.ManagerService;

public class DeleteMoviesUI extends BaseUI{
	
	private ManagerService service;
	
	public DeleteMoviesUI() {
		service = new ManagerService();
	}
	
	public void execute() throws Exception{
		String title = scanStr("상영종료한 영화 제목을 입력하세요: ");
		
		int cnt = service.selectByTitle(title);
		if (cnt == 0) {
			System.out.println("입력하신 영화 \"" + title + "\" 은(는) 상영하고 있지 않습니다\n");
		}else {
			service.deleteMovie(title);
			
			System.out.println("상영중인 영화 \"" + title +"\" 이(가) 성공정으로 상영종료했습니다\n");
		}		
	}
}
