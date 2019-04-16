package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ReservationVO;

public class ReservationDAO {
	static ReservationDAO single = null;
	public static ReservationDAO getInstance() {
		if(single==null) 
			single = new ReservationDAO();
		return single;
	}
	//---------------------------------
	SqlSessionFactory factory = null;
	public ReservationDAO() {
		//객체 생성 시 커넥터에서 factory 전달받음
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public int insert(ReservationVO vo) {
		int res = 0;
		SqlSession sqlSession = factory.openSession();
		
		res=sqlSession.insert("reservation.reservation_insert", vo);
		
		//내용 변경 갱신하기
		sqlSession.commit();
		sqlSession.close();
		
		
		return res;
	}
	
	public ReservationVO selectOne(ReservationVO vo) {
		ReservationVO res_vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		//파라미터로 CartVO를 넘겨줘서 select 쿼리 조건절에 사용
		res_vo = sqlSession.selectOne("reservation.reservation_one", vo);
		
		sqlSession.close();
		
		return res_vo;
	}
	
	public List<ReservationVO> selectList(int mem_idx){
		List<ReservationVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("reservation.reservation_list",mem_idx);
		
		sqlSession.close();
		return list;
	}
	
	public int delete(int r_idx) {
		int res = 0;
		
		SqlSession sqlSession = factory.openSession();
		res=sqlSession.delete("reservation.reservation_delete", r_idx);
		
		sqlSession.commit();
		sqlSession.close();
		
		return res;
	}
	
	public List<ReservationVO> selectAll(int s_idx){
		List<ReservationVO> list = null;
		
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("reservation.reservation_seat",s_idx);
		
		sqlSession.close();
		return list;
	}
	
	
}
