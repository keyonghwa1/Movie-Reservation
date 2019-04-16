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
 * Servlet implementation class ScreenResultAction
 */
@WebServlet("/movie/screen_insert_result.korea")
public class ScreenResultAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		String s_date = request.getParameter("s_date");
		String auditorium = request.getParameter("auditorium");
		String s_time = request.getParameter("s_time");
		
		System.out.println(m_idx);
		System.out.println(s_date);
		System.out.println(auditorium);
		System.out.println(s_time);

		ScreenVO vo = null;
		vo = new ScreenVO();
		
		vo.setM_idx(m_idx);
		vo.setS_date(s_date);
		vo.setS_time(s_time);
		vo.setAuditorium(auditorium);
		
		System.out.println();
		System.out.println(vo.getM_idx());
		System.out.println(vo.getS_date());
		System.out.println(vo.getS_time());
		System.out.println(vo.getAuditorium());
		
		
		int res = ScreenDAO.getInstance().insert(vo);
		System.out.println("처리된 행수 : " + res);
		
		RequestDispatcher disp = request.getRequestDispatcher("screen_list.korea");
		disp.forward(request, response);
		
		}
	

}
