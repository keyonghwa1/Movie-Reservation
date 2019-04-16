package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScreenDAO;
import vo.ScreenVO;

/**
 * Servlet implementation class ScreenViewAction
 */
@WebServlet("/movie/screen_view.korea")
public class ScreenViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		int s_idx = Integer.parseInt(request.getParameter("s_idx"));
		
		System.out.println(s_idx);
		
		ScreenVO vo = null;
		
		vo = ScreenDAO.getInstance().screenView(s_idx);
		
		
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher disp = request.getRequestDispatcher("screen_view.jsp");
		disp.forward(request, response);
		
	
	}

}
