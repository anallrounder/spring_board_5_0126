package edu.bit.board.service;

import java.util.List;

import edu.bit.board.vo.BoardVO;

public interface BoardService { //자손이 구현
	public List<BoardVO> getList();
	public void writeBoard(BoardVO boardVO);
	public BoardVO getBoard(int getbId); // 뷰 보여줄게 있으면 리턴타입 필요
	public void deleteBoard(int getbId);
	public void modifyBoard(BoardVO boardVO);
	public BoardVO getReplyBoard(int getbId);
	public void replyBoard(BoardVO boardVO);
	public void upHit(BoardVO boardVO);

}
