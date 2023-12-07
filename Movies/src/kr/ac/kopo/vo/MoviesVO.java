package kr.ac.kopo.vo;

public class MoviesVO {

	private int no;
	private String title;
	private int seatno;
	
	public MoviesVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoviesVO(int no, String title, int seatno) {
		super();
		this.no = no;
		this.title = title;
		this.seatno = seatno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}

	@Override
	public String toString() {
		return "MoviesVO [no=" + no + ", title=" + title + ", seatno=" + seatno + "]";
	}
}
