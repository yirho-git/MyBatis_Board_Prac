package myboard.dao;

import java.util.List;

import myboard.VO.BoardVO;

public interface BoardDAO {
	
	public int insertBoard(BoardVO vo);

	public List<BoardVO> displayAll(); 
	
	public List<BoardVO> searchBoard(BoardVO paramVO);
	
	public int updateBoard(BoardVO vo);
	
	public int deleteBoard(int brdNo);
}
