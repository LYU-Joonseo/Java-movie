package kr.ac.kopo.member.ui;

public class CancelUI extends BaseUI{
	
	public void execute() throws Exception{
		System.out.println("회원 탈퇴를 진행합니다.");
		String id = scanStr("아이디를 입력하세요: ");
		
		int cnt = service.selectById(id);
		if(cnt == 0) {
			System.out.println("입력하신 아이디 \"" + id + "\" 은(는) 존재하지 않습니다.");
		}else {
			String pass = scanStr("비밀번호를 입력하세요: ");
			int check = service.selectMember(id, pass);
			while(check == 0) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
				pass = scanStr("비밀번호를 입력하세요: ");
				check = service.selectMember(id, pass);
			}
			String agree = scanStr("탈퇴하시겠습니까? Y/N : ");
			switch (agree) {
			case "Y":
				service.Cancel(id);
				System.out.println("탈퇴가 완료되었습니다.\n");
				break;
			case "y":
				service.Cancel(id);
				System.out.println("탈퇴가 완료되었습니다.\n");
				break;
			case "N":
				System.out.println("탈퇴를 취소합니다.\n");
				break;
			case "n":
				System.out.println("탈퇴를 취소합니다.\n");
				break;
			default:
				System.out.println("잘못입력하였으므로 탈퇴를 종료합니다.\n");
			}
		}
	}

}
