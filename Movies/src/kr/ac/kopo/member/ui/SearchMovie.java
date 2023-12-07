package kr.ac.kopo.member.ui;

import java.util.ArrayList;
import java.util.List;
import kr.ac.kopo.vo.MoviesVO;

public class SearchMovie extends BaseUI{

	public void execute() throws Exception{
		List<MoviesVO> list = new ArrayList<MoviesVO>();
		String title = scanStr("검색하실 영화 제목을 입력하세요: ");
		list = service.searchTitle(title);
		System.out.println("----------------------------------------------");
		System.out.println("\t제목\t\t\t남은 좌석수");
		System.out.println("----------------------------------------------");
		if(list.size() == 0) {
			System.out.println("\t입력하신 \"" + title + "\"은(는) 상영하고 있지 않습니다.");
		}else {
			for(MoviesVO movie:list) {
				System.out.println("\t" + movie.getTitle() + "\t\t\t" + movie.getSeatno());
			}
		}
		System.out.println("----------------------------------------------");
		
	}
}
