package kr.ac.kopo.member.ui;

public class TicketCancelUI extends BaseUI{
	
	public void execute() throws Exception{
		String id = scanStr("아이디를 입력해주세요: ");
		String pass = scanStr("비밀번호를 입력해주세요: ");
		int check = service.selectMember(id, pass);
		if(check == 0) {
			System.out.println("입력하신 회원정보가 존재하지 않습니다.");
			System.out.println("예매 취소를 종료합니다.\n");
		}else {
			String title = scanStr("취소할 영화 제목을 입력하세요: ");
			int cnt = service.ticketByTitle(id, title);
			if(cnt == 0) {
				System.out.println("입력하신 회원님의 예매정보와 일치 하지않습니다.");
				System.out.println("예매 취소를 종료합니다.\n");
			}else {
				service.ticketCancel(id, title);
				System.out.println("예매를 취소하였습니다.");
			}
			
		}	
	}
}
