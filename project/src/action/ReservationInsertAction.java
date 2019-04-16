package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationDAO;
import vo.MemberVO;
import vo.ReservationVO;

/**
 * Servlet implementation class InsertReservationAction
 */
@WebServlet("/movie/reservation_insert.korea")
public class ReservationInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
		MemberVO mem_vo = (MemberVO) request.getSession().getAttribute("user");
		int mem_idx = 0;
		// vo가 null이면 세션에 저장되지 않은 것 = 로그인하지 않은 것
		if( mem_vo == null ) {
			response.sendRedirect("member_login.jsp");
			return;
		}
		else {
			mem_idx = mem_vo.getIdx();
		}
		
		
		
		StringBuffer sb = new StringBuffer();
		String [] arr = request.getParameterValues("seat");
		for(String seat : arr) {
			sb.append(seat);	
			sb.append(" ");
		}
		
//		System.out.println(sb);
		
		int s_idx	= Integer.parseInt(request.getParameter("s_idx"));		
		System.out.println(s_idx);
		String r_seat=sb.toString().trim();
//		System.out.println(r_seat);
		
		ReservationVO vo = new ReservationVO();
		vo.setMem_idx(mem_idx);
		vo.setS_idx(s_idx);
		vo.setR_seat(r_seat);
		
		ReservationVO res_vo = ReservationDAO.getInstance().selectOne( vo );
		
		
		String result = "no";
		if( res_vo == null ) { // 객체가 없으면 테이블에 없는 것!
			result = "yes"; // 돌려줄 결과 값
			ReservationDAO.getInstance().insert(vo); // DB에 추가 
		}
		
		RequestDispatcher disp = request.getRequestDispatcher("reservation_list.korea");
		disp.forward(request, response);
	}

}
