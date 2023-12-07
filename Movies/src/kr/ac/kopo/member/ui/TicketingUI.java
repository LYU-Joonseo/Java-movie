package kr.ac.kopo.member.ui;

import kr.ac.kopo.service.ManagerService;
import kr.ac.kopo.vo.TicketVO;

public class TicketingUI extends BaseUI{

	private ManagerService mService;
	
	public TicketingUI() {
		mService = new ManagerService();
	}
	public void execute() throws Exception{
		System.out.println("영화 예매를 진행합니다.");
		String title = scanStr("원하는 영화 제목을 입력하세요: ");
		int cnt = mService.selectByTitle(title);
		if(cnt == 0) {
			System.out.println("현재 \"" + title + "\" 은(는) 상영하고 있지 않습니다.");
		}else {
			int count = service.countSeat(title);
			if (count == 0) {
				System.out.println("현재 \"" + title + "\"은(는) 남은 좌석이 없습니다.");
			}else {
				String id = scanStr("아이디를 입력해주세요: ");
				String pass = scanStr("비밀번호를 입력해주세요: ");
				int check = service.selectMember(id, pass);
				if(check == 0) {
					System.out.println("입력하신 회원정보가 존재하지 않습니다.");
					System.out.println("예매를 종료합니다.\n");
				}else {
					int seatCnt = scanInt("예매하실 좌석의 수를 입력하세요: ");
					
					if(seatCnt >= 100 || seatCnt > count || (count - seatCnt) < 0) {
						System.out.println("허용 좌석수를 초과하였습니다.");
						System.out.println("예매를 종료합니다.\n");
					}else {
						TicketVO ticket = new TicketVO();
						ticket.setId(id);
						ticket.setTitle(title);
						ticket.setSeat_cnt(seatCnt);
						
						service.ticketing(ticket, seatCnt, title);
						
						System.out.println("예매 완료하였습니다.");
					}
				}
			}
		}
	}
}
