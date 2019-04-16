package vo;

public class MovieVO {
	private int m_idx;
	private int s_idx;
	private String category;
	private String m_title;
	private String m_dir;
	private String m_price;
	private String m_img;
	private String s_date;
	private String s_time;
	private String s_teather;
	
	public MovieVO() {
		
	}

	public MovieVO(int m_idx, String category, String m_title, String m_dir, String m_price, String m_img,
			int s_idx, String s_date, String s_time, String s_teather) {
		
		this.m_idx = m_idx;
		this.s_idx = s_idx;
		this.category = category;
		this.m_title = m_title;
		this.m_dir = m_dir;
		this.m_price = m_price;
		this.m_img = m_img;
		this.s_date = s_date;
		this.s_time = s_time;
		this.s_teather = s_teather;
	}

	public int getM_idx() {
		return m_idx;
	}

	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}

	public int getS_idx() {
		return s_idx;
	}

	public void setS_idx(int s_idx) {
		this.s_idx = s_idx;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}

	public String getM_dir() {
		return m_dir;
	}

	public void setM_dir(String m_dir) {
		this.m_dir = m_dir;
	}

	public String getM_price() {
		return m_price;
	}

	public void setM_price(String m_price) {
		this.m_price = m_price;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
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

	public String getS_teather() {
		return s_teather;
	}

	public void setS_teather(String s_teather) {
		this.s_teather = s_teather;
	}


	
}
