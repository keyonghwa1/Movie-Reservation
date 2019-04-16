package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberListAction
 */
@WebServlet("/movie/member_list.korea")
public class MemberListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// memberlist.jsp 를 호출하면, 여기서 <% %> 자바 코드로 list를 select 하는 형태였음
		//여기가 목록을 보는 메인 url이 될 것
		//여기에서 DB의 목록을 select 하는 작업을 한 후, list를 만든 뒤, 
		//requestScope에 만든 list를 추가하여 view 페이지로 이동  
		
		//DAO를 통해 DB의 목록을 select하여 리스트를 반환받기
		List<MemberVO> list = MemberDAO.getInstance().selectList();
		
		//requestScope에  list를 바인딩
		request.setAttribute("list", list);
		
		//forward() : 현재 호출된 요청, 응답을 그대로 가지고 이동(현재 request에 추가된 list를 들고 호출)
		//	redirect는 그냥 새로 이동하는 것
		RequestDispatcher disp = request.getRequestDispatcher("member_list.jsp");
		disp.forward(request, response);
		//위 두 줄은 세트
	}

}
