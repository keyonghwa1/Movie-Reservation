package vo;

public class MemberVO {
	private int mem_idx;
	private String mem_name,mem_id, mem_pwd, mem_phone;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(int mem_idx,String mem_name, String mem_id, String mem_pwd, String mem_phone) {
		super();
		this.mem_idx = mem_idx;
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_pwd = mem_pwd;
		this.mem_phone = mem_phone;
	}

	public int getIdx() {
		return mem_idx;
	}

	public void setIdx(int mem_idx) {
		this.mem_idx = mem_idx;
	}

	public String getName() {
		return mem_name;
	}
	public String getId() {
		return mem_id;
	}
	public void setId(String mem_id) {
		this.mem_id = mem_id;
	}

	public void setName(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getPwd() {
		return mem_pwd;
	}

	public void setPwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getPhone() {
		return mem_phone;
	}

	public void setPhone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	
	
}
