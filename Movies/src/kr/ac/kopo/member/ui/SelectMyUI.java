package kr.ac.kopo.member.ui;

import java.util.List;
import kr.ac.kopo.vo.TicketVO;

public class SelectMyUI extends BaseUI{

	public void execute() throws Exception{
		System.out.println("예매한 영화 조회를 진행합니다.");
		String id = scanStr("조회할 아이디를 입력하세요: ");
		
		List<TicketVO> list = service.myTicket(id);
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t\t" + id +"님의 예매 현황");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t번호\t아이디\t영화 제목\t\t예매한 좌석수");
		if(list.isEmpty()) {
			System.out.println("\t현재 예매하신 영화가 없습니다.\n");
		}else {
			for(TicketVO ticket : list) {
				System.out.println("\t" + ticket.getNo() + "\t" + ticket.getId() + "\t" + ticket.getTitle() + "\t\t" + ticket.getSeat_cnt());
			}
		}
		System.out.println("-------------------------------------------------------------------");
	}
}
