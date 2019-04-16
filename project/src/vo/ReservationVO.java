package vo;

public class ReservationVO {
	int r_idx, mem_idx, s_idx,m_idx;
	String r_seat, r_time,s_date,s_time,auditorium,m_img,m_title,m_price;
	
	public ReservationVO() {
		// TODO Auto-generated constructor stub
	}

	public ReservationVO(int r_idx, int mem_idx, int s_idx, int m_idx, String r_seat, String r_time, String s_date,
			String s_time, String auditorium, String m_img, String m_title, String m_price) {
		super();
		this.r_idx = r_idx;
		this.mem_idx = mem_idx;
		this.s_idx = s_idx;
		this.m_idx = m_idx;
		this.r_seat = r_seat;
		this.r_time = r_time;
		this.s_date = s_date;
		this.s_time = s_time;
		this.auditorium = auditorium;
		this.m_img = m_img;
		this.m_title = m_title;
		this.m_price = m_price;
	}

	public int getR_idx() {
		return r_idx;
	}

	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}

	public int getMem_idx() {
		return mem_idx;
	}

	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}

	public int getS_idx() {
		return s_idx;
	}

	public void setS_idx(int s_idx) {
		this.s_idx = s_idx;
	}

	public int getM_idx() {
		return m_idx;
	}

	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}

	public String getR_seat() {
		return r_seat;
	}

	public void setR_seat(String r_seat) {
		this.r_seat = r_seat;
	}

	public String getR_time() {
		return r_time;
	}

	public void setR_time(String r_time) {
		this.r_time = r_time;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public String getS_time() {
		return s_time;
	}

	public void setS_time(String s_time) {
		this.s_time = s_time;
	}

	public String getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(String auditorium) {
		this.auditorium = auditorium;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	
	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	
	public String getM_price() {
		return m_price;
	}

	public void setM_price(String m_price) {
		this.m_price = m_price;
	}

	
	
	
}
