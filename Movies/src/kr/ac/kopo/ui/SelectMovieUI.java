package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.member.ui.BaseUI;
import kr.ac.kopo.vo.MoviesVO;

public class SelectMovieUI extends BaseUI{

	public void execute() throws Exception{
		
		List<MoviesVO> list = service.selectMovies();
		
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t\t상영중인 영화 조회");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t번호\t제목\t\t\t남은 좌석수");
		if(list.isEmpty()) {
			System.out.println("\t   상영중인 영화가 없습니다");
		}else {
			for(MoviesVO movies : list) {
				System.out.println("\t" + movies.getNo() + "\t" + movies.getTitle() + "\t\t\t" + movies.getSeatno());
			}
		}
		System.out.println("-------------------------------------------------------------------");
	}
}
