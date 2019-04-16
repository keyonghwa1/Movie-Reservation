package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationDAO;
import vo.MemberVO;
import vo.ReservationVO;

/**
 * Servlet implementation class ReservationListAction
 */
@WebServlet("/movie/reservation_list.korea")
public class ReservationListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = (MemberVO) request.getSession().getAttribute("user");
		int m_idx = 0;
		
		if( vo == null ) {
			
		}
		else {
			m_idx = vo.getIdx();
		}
		
		List<ReservationVO> list= ReservationDAO.getInstance().selectList(m_idx);
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("reservation_list.jsp");
		disp.forward(request, response);
		
		
	}

}
