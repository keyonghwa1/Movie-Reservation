package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.sound.SoftSynthesizer;

import dao.MovieDAO;
import util.Paging;
import vo.MovieVO;


/**
 * Servlet implementation class MovieListAction
 */
@WebServlet("/movie/movie_list.korea")
public class MovieListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		// index.jsp 에서, 카테고리 클릭 시 이 URL로 파라미터를 전달한다.
		// list.korea?category=com001
		String category = request.getParameter("category");

		System.out.println(category);
		
		
		if(category==null || category.isEmpty() ) {
			// 파라미터 없이 호출되면, 기본 카테고리를 '컴퓨터'로 한다.
			category = "romance";
		}
		
		////////////////////////////////////////////////////////////////
		// 페이징 코드 추가
		//		> 제품목록을 가져오기 전에,
		//			몇 페이지인지
		//			한 페이지에 보여질 항목의 수,
		//			전체 페이지 목록
		String page = request.getParameter("page"); // ~.korea?page=2
		
		int currentPage = 1; // 현재 페이지 번호(파라미터가 없을 것도 가정) 없으면 기본 1페이지
		
		if( page != null && page.equals("") == false ) {
		// page 파라미터로 값이 들어왔다면, 정수로 변환
		currentPage = Integer.parseInt(page);
		}
		
		int pageSize = 10; // 한 화면에 보여질 항목 수(경우에 따라 알아서 처리) 임의로 10개
		
		// 전체 항목의 개수 (DB에서 count(*)로 조회한다.)
		int totalSize = MovieDAO.getInstance().selectCount();
		
		// 별도로 만들어둔 Paging 객체를 생성한다.
		// util 패키지에 Paging 클래스 생성
		Paging paging = new Paging( pageSize, totalSize, currentPage );
		// 생성자에서 3개의 값을 가지고 calc() 메서드를 수행하여 모든 멤버변수의 값이 만들어졌다.
		System.out.println(paging);
		// startNo, endNo를 가지고 쿼리문을 수행해야 하는데, 파라미터가 여러개라서 HashMap을 사용
		HashMap<String, String> map = new HashMap<>();
		map.put("startNo", paging.getStartNo() + ""); // int를 문자열로 만들었음
		map.put("endNo", paging.getEndNo() + "");
		map.put("category", category); // 쇼핑몰에서는 카테고리가 조건에 필요해서 추가했음
		
		// 기존 select() 메서드가 아닌 map을 파라미터로 전달받는 메서드로 오버로딩
		List<MovieVO> list = MovieDAO.getInstance().select(map);
		// list에는 필요한 개수만큼의 목록이 만들어진다.(10개면 10개, 20개면 20개)
		
		// request에 paging 객체를 넣어두면
		// jsp에서 페이지의 정보를 알 수 있으니, 페이지관련 태그를 추가할 수 있다.
		request.setAttribute("paging", paging);
		
		
		
		//  페이징 안된 목록
		// 제품 카테고리별 목록 조회
		// List : ArrayList가 구현한 인터페이스 (ArrayList 처럼 쓰면됨)
		List<MovieVO> listca = MovieDAO.getInstance().select(category);
		
		
		request.setAttribute("list", list);
		request.setAttribute("listca", listca);
		

		// list.korea 호출 --> 카테고리에 따라 DB에서 조회 --> product_list.jsp 호출 (view 페이지)
		RequestDispatcher disp = request.getRequestDispatcher("movie_list.jsp");
		disp.forward(request, response);
	}
		
}


