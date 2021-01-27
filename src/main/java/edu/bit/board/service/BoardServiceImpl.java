package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service //서비스 컨트롤러 레포지토리에서 객체생성하게 만들어줌
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {	//자손이 구현
	
	@Autowired
	private BoardMapper mapper; // 하지만 이 객체는 어떤식으로 생성?
	
	//1) new 로 직접 생성
	//2) @Inject or @Aotowired (뜻이 new 해서 객체를 저 mapper에 담아줌)
	//스프링 5.0부터는 저 2번 안써줘도 생성자로 (@AllArgsContructor-롬복)으로 가지고있으니까 자동으로 오토로 들어가게 되어있다.
	// 우리는 5.0.7?버전? 씀??
	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();  //이거만 일단 추가하자
	}

	@Override
	public void writeBoard(BoardVO boardVO) {
		mapper.insert(boardVO); //여기 객체를 넣고있다.
		// 리턴값 없어서 안함
	}
		
}
