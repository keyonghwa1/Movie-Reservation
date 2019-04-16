package vo;

public class ScreenVO {
	private int s_idx;
	private int m_idx;
	private String s_date;
	private String s_time;
	private String auditorium;
	
	public ScreenVO() {
		
	}

	public ScreenVO(int s_idx, int m_idx, String s_date, String s_time, String auditorium) {
	
		this.s_idx = s_idx;
		this.m_idx = m_idx;
		this.s_date = s_date;
		this.s_time = s_time;
		this.auditorium = auditorium;
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
	
	
}
