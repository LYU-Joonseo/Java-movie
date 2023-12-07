package kr.ac.kopo.member.ui;

import kr.ac.kopo.vo.MemberVO;

public class SignUpUI extends BaseUI{

	public void execute() throws Exception{
		String id = scanStr("아이디를 입력하세요: ");
		String pass = scanStr("비밀번호를 입력하세요: ");
		String name = scanStr("이름을 입력하세요: ");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(pass);
		member.setName(name);
		
		int cnt = service.selectById(id);
		if(cnt == 0) {
			service.signUp(member);
			System.out.println("가입이 완료되었습니다.\n");		
		}else {
			System.out.println("이미 존재하는 아이디입니다\n");
		}
	}
}
