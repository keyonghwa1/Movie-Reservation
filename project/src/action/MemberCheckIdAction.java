package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/movie/check_id.korea")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		
		//DAO에 해당 id가 존재하는지 select 쿼리를 where조건으로 수행!
		// vo를 반환받아서 vo 객체가 null이면 아이디가 없는 것으로 판별
		MemberVO vo = MemberDAO.getInstance().selectId(id); 
		
		//반환된 결과를 이용하여, JSON 타입 값을 만들어서 콜백함수로 보낸다
		String res = "no"; //회원가입이 불가능!(존재)
		
		if(vo == null) { //null이다 = 조회안됨
			res="yes"; //회원가입 가능
		}
		
		response.setContentType("text/plain;charset=utf-8"); 
		
		//[{'result':'yes'} , {'id':'abcde'}] 형태로 만들기
		String resultStr = String.format("[{'result':'%s'},{'id':'%s'}]",res,id );
		
		response.getWriter().println(resultStr); //응답 페이지에 내용 쓰기
	}

}
