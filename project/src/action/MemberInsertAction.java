package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberInsertAction
 */
@WebServlet("/movie/member_insert.korea")
public class MemberInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST로 DB에 추가할 회원 정보가 전달된다. (URL에 파라미터가 보이지 않음)
		//	GET방식으로 처리가 된다면.. URL 조작해서 계속 추가할 수도 있음!!
		//	항상 DB가 변경되는 행위는 POST로..!
		
		// POST라고 치고~~!
		//	> getMethod() 를 이용하여, GET이면 아무처리를 안 하거나...
		//	> doPost() 만을 구현해도 된다.
		
		// service() 메서드가 GET/POST 판별하여, doGet(), doPost() 를 호출하는 원리
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		// DAO에 존재할 insert 메서드로, 값들을 하나하나 넘겨줘도 되지만.. 불편
		// insert() 메서드로 전달할 VO 생성
		MemberVO vo = new MemberVO(0, name, id, pwd, phone);
		// idx는 시퀀스를 이용하여 자동증가 시킬 예정이라 아무 값이나 넣었음
		
		MemberDAO.getInstance().insert( vo );
		
		// 안드로이드
		String type = request.getParameter("type");
		String resultStr="";

	if(type.equalsIgnoreCase("type_regi")) {
		
		resultStr = String.format("{'res':[{'result':'%s'}]}","success" );
		
		// 이거 해줘야 됨~~ json으로 줄 때
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println( resultStr );
		
		if(vo.getName().equals("관리자")) {
			System.out.println("저 관리자");
			//RequestDispatcher disp = request.getRequestDispatcher("member_list.korea");
			//disp.forward(request, response);
		
		}
		
		else{
			//RequestDispatcher disp = request.getRequestDispatcher("member_login.jsp");
			//disp.forward(request, response);
		}
	}
	else if(type == null) {
		
		resultStr = String.format("{'res':[{'result':'%s'}]}","fail");
		// 이거 해줘야 됨~~ json으로 줄 때
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println( resultStr );
		
	}
		
	
		// 추가 완료 후, 페이지를 목록 페이지로 다시 이동
		
		// 서블릿(컨트롤러)로 이동한다 = 다시 select 하고 jsp(뷰)로 forward 하겠다.
		
	}

}