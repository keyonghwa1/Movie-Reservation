package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/movie/login.korea")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 나는 login_form.jsp 에서 호출하는 url이다!!
		//	고로, id, pwd 파라미터가 존재한다!
		//	파라미터 없이 그냥 호출하면 안 된다! (잘못된 접근)
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// DAO를 통해 id를 select 해서 vo로 반환
		// Member vo = MemberDAO.getInstance().selectId(id);
		//	vo == null		--> id 가 없다.
		//	vo.getPwd() 와 pwd를 비교해서 같지 않다 --> pw 잘못됨
		// 	그것도 아니다 --> 성공
		
		MemberVO vo = MemberDAO.getInstance().selectId(id);
		String param 		= ""; // param의 값
		String resultStr 	= ""; // 전송될 json 문자열
		
		System.out.println("=====================");
		
		if( vo == null || vo.getId().equals(id) == false ) {
			param = "no_id";
		}
		else if( vo.getPwd().equals(pwd) == false ) {
			param = "no_pwd";
		}
		else {
			// 아이디, 패스워드가 다르지 않았다면, 여기는 성공!
			param = "clear";
			
			// 정상이라면 '세션'에 데이터 저장
			HttpSession session = request.getSession();
			// DB와 VO를 다룬다면, 세션에 그냥 vo만 넣으면 끝  set~~("user", vo);
			session.setAttribute("user", vo);
			session.setAttribute("name", vo.getName());
		}
		
		resultStr = String.format("[{'param':'%s'}]", param);
		// 이거 해줘야 됨~~ json으로 줄 때
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println( resultStr );
		
	}

}
