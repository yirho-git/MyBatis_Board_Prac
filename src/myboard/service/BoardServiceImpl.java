package myboard.service;

import java.util.List;

import myboard.VO.BoardVO;
import myboard.dao.BoardDAOImpl;
import myboard.dao.IBoardDAO;

public class BoardServiceImpl implements IBoardService {
	private static IBoardService service = new BoardServiceImpl();
	private IBoardDAO dao = BoardDAOImpl.getInstance();

	private BoardServiceImpl() {
		
	}

	public static IBoardService getInstance() {
		return service;
	}

	@Override
	public int write(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> showAll() {
		return dao.displayAll();
	}

	@Override
	public List<BoardVO> search(BoardVO paramVO) {
		return dao.searchBoard(paramVO);
	}

	@Override
	public int edit(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int erase(int brdNo) {
		return dao.deleteBoard(brdNo);
	}

}
