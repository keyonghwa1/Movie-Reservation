package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ScreenDAO;

import vo.ScreenVO;

/**
 * Servlet implementation class ScreenListAction
 */
@WebServlet("/movie/screen_list.korea")
public class ScreenListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setCharacterEncoding("utf-8");
		// index.jsp 에서, 카테고리 클릭 시 이 URL로 파라미터를 전달한다.
		// list.korea?category=com001
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));

		System.out.println(m_idx);
		
	
		
		// 제품 카테고리별 목록 조회
		// List : ArrayList가 구현한 인터페이스 (ArrayList 처럼 쓰면됨)
		List<ScreenVO> list = ScreenDAO.getInstance().select(m_idx);
		request.setAttribute("list", list);
		

				// list.korea 호출 --> 카테고리에 따라 DB에서 조회 --> product_list.jsp 호출 (view 페이지)
		RequestDispatcher disp = request.getRequestDispatcher("screen_list.jsp");
		disp.forward(request, response);
		
	}

}
