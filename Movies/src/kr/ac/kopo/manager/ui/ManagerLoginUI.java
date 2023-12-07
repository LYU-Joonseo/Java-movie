package kr.ac.kopo.manager.ui;

import kr.ac.kopo.member.ui.BaseUI;
import kr.ac.kopo.service.ManagerService;
import kr.ac.kopo.ui.IMoviesUI;
import kr.ac.kopo.vo.ManagerVO;

public class ManagerLoginUI extends BaseUI{

	private ManagerService service;
	
	public ManagerLoginUI() {
		service = new ManagerService();
	}

	@Override
	public void execute() throws Exception {
		
		IMoviesUI ui = null;
		System.out.println("------------------------------------------------------");
		System.out.println("\t< 관리자 전환 >");
		String id = scanStr("관리자 아이디를 입력하세요: ");
		String pass = scanStr("관리자 패스워드를 입력하세요: ");
		
		ManagerVO manager = new ManagerVO();
		manager.setId(id);
		manager.setPass(pass);
		ManagerVO log = service.login(manager);
		
		if(log == null) {
			System.out.println("\n아이디와 비밀번호가 일치하지않습니다.");
			System.out.println("메뉴화면으로 돌아갑니다.");
		}else {
			System.out.println("관리자 전환 완료하였습니다.\n");
			ui = new ManagerUI();
			ui.execute();
		}
	}
}
