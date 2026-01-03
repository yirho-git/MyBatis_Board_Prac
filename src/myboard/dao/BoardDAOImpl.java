package myboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import myboard.VO.BoardVO;
import myboard.util.myBatisUtil;

public class BoardDAOImpl implements IBoardDAO {

	private static IBoardDAO dao = new BoardDAOImpl();
	
	private BoardDAOImpl() {

	}
	
	public static IBoardDAO getInstance() {
		return dao;
	}
	

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
			bList = session.selectList("board.showAll");
			
			if(bList == null || bList.isEmpty()) {
				bList = null;
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
		int cnt = 0;
		try(SqlSession session = myBatisUtil.getSqlSession()){
			cnt = session.update("board.update", vo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(int brdNo) {
		int cnt=0;
		try(SqlSession session = myBatisUtil.getSqlSession()){
			cnt = session.delete("board.delete", brdNo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return cnt;
	}

}
