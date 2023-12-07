 package kr.ac.kopo;

import kr.ac.kopo.member.ui.MoviesUI;

public class MoviesMain {

	public static void main(String[] args) {
		
		MoviesUI ui = new MoviesUI();
		
		try {
			ui.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
