package myboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myboard.VO.BoardVO;
import myboard.util.myBatisUtil;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public int insertBoard(BoardVO vo) {
		int cnt = 0;
		try(SqlSession session = myBatisUtil.getSqlSession() ) {
			
			cnt = session.insert("board.brdWrite",vo);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> displayAll() {
		List<BoardVO> bList = null;
		try(SqlSession session = myBatisUtil.getSqlSession()){
			bList = session.selectList("board.ShowAll");
			
			if(bList == null || bList.isEmpty()) {
				bList = null;
				//System.out.println("게시글이 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO paramVO) {
		List<BoardVO> bList = null;
		try(SqlSession session = myBatisUtil.getSqlSession()){
			bList = session.selectList("board.search", paramVO);
			
			if(bList==null||bList.isEmpty()) {
				bList=null;
				//System.out.println("게시글이 존재하지 않습니다");
			}else {
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		
		return 0;
	}

	@Override
	public int deleteBoard(int brdNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
