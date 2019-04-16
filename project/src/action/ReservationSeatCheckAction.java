package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservationDAO;
import vo.ReservationVO;

/**
 * Servlet implementation class ReservationSeatCheckAction
 */
@WebServlet("/movie/reservation_seat_check.korea")
public class ReservationSeatCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int s_idx = Integer.parseInt(request.getParameter("s_idx"));
		
		List<ReservationVO> list = ReservationDAO.getInstance().selectAll(s_idx);
		
		ArrayList<Integer> already_list = new ArrayList<>();
		
		for( ReservationVO vo : list ) {
			String [] arr = vo.getR_seat().split(" ");
			
			System.out.println(arr);
			
			for( int i = 0; i < arr.length; i++ ) {
				already_list.add( Integer.parseInt(arr[i]) );
			}
		}

		Collections.sort(already_list);
		
		StringBuffer sb = new StringBuffer();
		for( int num : already_list ) {
			sb.append(num+",");
		}
		
		if( sb.length() > 0 ) 
			sb.deleteCharAt( sb.length()-1 );
		
		System.out.println(sb.toString());
		
		request.setAttribute("already_seat", sb.toString());
		RequestDispatcher disp = request.getRequestDispatcher("movie_seat_reservation.jsp");
		disp.forward(request, response);
	}

}
