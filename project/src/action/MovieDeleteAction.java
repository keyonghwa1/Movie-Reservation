package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dao.MovieDAO;

/**
 * Servlet implementation class MovieDeleteAction
 */
@WebServlet("/movie/movie_del.korea")
public class MovieDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		System.out.println(m_idx);
		
		//DAO에서 해당 idx의 행을 지우는 작업을 완료한 뒤, 결과 값을 받는다.
		int res = MovieDAO.getInstance().delete(m_idx);
		//1이면 성공, 0이면 실패
		System.out.println(res);
		//json 반환
		String result = String.format("[{'res':'%d'},{'m_idx':'%d'}]",res,m_idx);
		response.getWriter().println(result);
		
	}

}
