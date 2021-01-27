package edu.bit.board.mapper;

import java.util.List;

import edu.bit.board.vo.BoardVO;

public interface BoardMapper { //dao부분 - 맵퍼로 사용 (신세계. 이제 마이바티스 들어감)
	//dao mapper부분이 핵심이다.
	
	public List<BoardVO> getList(); 
	public void insert(BoardVO boardVO); // 리턴타입없다. 리절트없다.
}