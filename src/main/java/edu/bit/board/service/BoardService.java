package edu.bit.board.service;

import java.util.List;

import edu.bit.board.vo.BoardVO;

public interface BoardService { //자손이 구현
	public List<BoardVO> getList();
	public void writeBoard(BoardVO boardVO);
}
