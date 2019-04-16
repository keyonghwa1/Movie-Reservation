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
 * Servlet implementation class ReservationTimeAction
 */
@WebServlet("/movie/reservation_time.korea")
public class ReservationTimeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		List<ScreenVO> list = ScreenDAO.getInstance().select(m_idx);
		
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("reserve_time.jsp");
		disp.forward(request, response);

	}
}