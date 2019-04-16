package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationDAO;

/**
 * Servlet implementation class ReservationDeleteAction
 */
@WebServlet("/movie/reservation_delete.korea")
public class ReservationDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int r_idx = Integer.parseInt(request.getParameter("r_idx"));
		int res = ReservationDAO.getInstance().delete(r_idx);
		
		System.out.println("처리된 행 수 :"+res);
		response.sendRedirect("reservation_list.korea");
	}

}
