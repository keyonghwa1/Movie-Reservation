package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginClearAction
 */
@WebServlet("/movie/clear.korea")
public class LoginClearAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 성공 후  처리할 작업이 있다면 여기서 처리
		RequestDispatcher disp = request.getRequestDispatcher("movie_main.jsp");
		disp.forward(request, response);
	}

}
