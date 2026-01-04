package myboard.service;

import java.util.List;

import myboard.VO.BoardVO;

public interface IBoardService {
	
	public int write(BoardVO vo);

	public List<BoardVO> showAll(); 
	
	public List<BoardVO> search(BoardVO paramVO);
	
	public int edit(BoardVO vo);
	
	public int erase(int brdNo);
}
