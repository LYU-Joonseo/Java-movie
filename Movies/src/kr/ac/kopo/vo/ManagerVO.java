package kr.ac.kopo.vo;

public class ManagerVO {

	private String id;
	private String pass;
	
	public ManagerVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManagerVO(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "ManagerVO [id=" + id + ", pass=" + pass + "]";
	}	
}
