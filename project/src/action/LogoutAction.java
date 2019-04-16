package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutAction
 */
@WebServlet("/movie/logout.korea")
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//main_content.jsp. 는 로그인이 되어있어야만, 환영합니다![로그아웃] 이 있다
		//로그인 된 상태(세션에 값이 있는 상태) 일 때만 로그아웃 버튼이 눌리면서 여기로 온디
		
		//로그인 체크를 세션의 "name"으로 했기 때문에, 해당 값을 지워버리면 끝
		request.getSession().removeAttribute("name");
		
		RequestDispatcher disp = request.getRequestDispatcher("member_login.jsp");
		disp.forward(request, response);
	}

}
