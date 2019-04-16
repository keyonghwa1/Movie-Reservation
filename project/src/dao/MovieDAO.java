package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MovieVO;

public class MovieDAO {
	private static MovieDAO single = null;
	
	public static MovieDAO getInstance() {
		if(single == null)
			single = new MovieDAO();
		return single;
	}
	// ----------------------------------
	SqlSessionFactory factory = null;
	
	public MovieDAO() {
		// 객체 생성 시 커넥터에서 factory 전달 받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<MovieVO> select(String category) {
		List<MovieVO> list = null;
	
		SqlSession sqlSesson = factory.openSession();
		list = sqlSesson.selectList("movie.movie_list",category);
		
		sqlSesson.close();
		
		return list;
	}

	public int insert(MovieVO vo) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res = sqlSession.insert("movie.movie_insert", vo);
		
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}

	public MovieVO selectOne(int m_idx) {
		MovieVO vo = null;
		
		SqlSession sqlSesson = factory.openSession();
		vo = sqlSesson.selectOne("movie.movie_list_one", m_idx);
		
		sqlSesson.close();
		
		return vo;
	}
	
	public int delete(int m_idx) {
		int res = 0;
		
		SqlSession sqlSession=factory.openSession();
		res = sqlSession.delete("movie.movie_delete",m_idx);
		
		sqlSession.commit(); // insert, update, delete --> 커밋! 
		sqlSession.close();
		
		return res;
	}

	public int selectCount() {
		SqlSession sqlSession = factory.openSession();
		
		int count = (int)sqlSession.selectOne("movie_count");
		sqlSession.close();
		
		return count;
	}

	public List<MovieVO> select(HashMap<String, String> map) {
		List<MovieVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("movie_list_page", map);
		sqlSession.close();
		
		return list;
	}
}