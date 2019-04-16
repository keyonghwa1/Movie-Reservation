package action;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MovieDAO;
import vo.MovieVO;


/**
 * Servlet implementation class MovieInsertResultAction
 */
@WebServlet("/movie/movie_insert_result.korea")
public class MovieInsertResultAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String path = request.getServletContext().getRealPath("/images/");
		System.out.println(path);
		
		int max_size = 1024*1024*100; 
	
		MultipartRequest mr = new MultipartRequest(
													request, 
													path, // 업로드 위치
													max_size, // 최대 업로드 용량
													"utf-8", // 수신 인코딩
													new DefaultFileRenamePolicy());
		
		String m_img = "no_file";
		
		File f = mr.getFile("m_img"); // <input type="file" name="m_img">
		if(f != null) {
			m_img = f.getName(); // 실제로 업로드된 파일명 (중복돼서 리네임 됐을 수도 있다.)
			
		}
		
		
		// 파일 외의 파라미터 획득 (request 에선 찾을수 없다)
		String category = mr.getParameter("category");
		String m_title = mr.getParameter("m_title");
		String m_dir = mr.getParameter("m_dir");
		String m_price = mr.getParameter("m_price");
	
		
		System.out.println(category);
		System.out.println(m_title);
		System.out.println(m_dir);
		System.out.println(m_price);

		MovieVO vo = new MovieVO();
		
		vo.setCategory(category);
		vo.setM_title(m_title);
		vo.setM_dir(m_dir);
		vo.setM_price(m_price);
		vo.setM_img(m_img);
		

		// DB에 insert
		int res = MovieDAO.getInstance().insert(vo);
		System.out.println("결과값 : " + res);

		// 추가한 제품의 카테고리 리스토로 페이지 이동 (추가된걸 목록에서 바로 확인 가능)
		response.sendRedirect("movie_list.korea?category=" + category);
		
		
		
		
	}

}
