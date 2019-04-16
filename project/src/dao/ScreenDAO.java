package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ScreenVO;

public class ScreenDAO {

	private static ScreenDAO single = null;
		
	public static ScreenDAO getInstance() {
		if(single == null)
			single = new ScreenDAO();
			return single;
		}
		// ----------------------------------
		SqlSessionFactory factory = null;
		public ScreenDAO() {
			// 객체 생성 시 커넥터에서 factory 전달 받음
			factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		}
	
		public int insert(ScreenVO vo) {
			
			int res = 0;
			SqlSession sqlSession = factory.openSession();
			
			System.out.println(vo.getM_idx());
			System.out.println(vo.getS_date());
			System.out.println(vo.getS_time());
			System.out.println(vo.getAuditorium());
			
			
			res = sqlSession.insert("screen.screen_insert", vo);
			
			sqlSession.commit();
			sqlSession.close();
			
			
			return res;
			
			
		}

		public List<ScreenVO> select(int m_idx) {
			
			List<ScreenVO> list = null;
			
			SqlSession sqlSession = factory.openSession();
			list = sqlSession.selectList("screen.screen_list", m_idx);
			

			sqlSession.close();
			
			
			return list;
		}

		public ScreenVO screenView(int s_idx) {
			
			ScreenVO vo = null;
			SqlSession sqlSession = factory.openSession();
			vo = sqlSession.selectOne("screen.screen_view", s_idx);
		
			sqlSession.close();
	
			return vo;
		}


		

	
		
}
