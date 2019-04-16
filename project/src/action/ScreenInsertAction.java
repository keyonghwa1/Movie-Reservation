package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDAO;
import vo.MovieVO;





/**
 * Servlet implementation class ScreenInsertAction
 */
@WebServlet("/movie/screen_insert.korea")
public class ScreenInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int m_idx = Integer.parseInt(request.getParameter("m_idx")); // 영화 고유번호의 상영정보 집어넣을려고함
		
		MovieVO vo = MovieDAO.getInstance().selectOne( m_idx ); 
		
		request.setAttribute("vo", vo);
		

		RequestDispatcher disp = request.getRequestDispatcher("screen_reg_form.jsp"); // 영화상영정보
		disp.forward(request, response);
		

			
		
	}

}
