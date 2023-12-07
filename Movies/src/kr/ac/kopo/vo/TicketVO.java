package kr.ac.kopo.vo;

public class TicketVO {

	private int no;
	private String id;
	private String title;
	private int seat_cnt;
	
	public TicketVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketVO(int no, String id, String title, int seat_cnt) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.seat_cnt = seat_cnt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSeat_cnt() {
		return seat_cnt;
	}

	public void setSeat_cnt(int seat_cnt) {
		this.seat_cnt = seat_cnt;
	}

	@Override
	public String toString() {
		return "TicketVO [no=" + no + ", id=" + id + ", title=" + title + ", seat_cnt=" + seat_cnt + "]";
	}
}
