package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		log.info("get all List completed");
		return mapper.getList();  //이거만 일단 추가하자
	}

	@Override
	public void writeBoard(BoardVO boardVO) {
		log.info("insert completed");
		mapper.insert(boardVO); //여기 객체를 넣고있다.
		// 리턴값 없어서 안함
	}

	@Override
	public BoardVO getBoard(int bno) {
		log.info("getBoard.......");
		return mapper.read(bno);
	}

	@Override
	public void deleteBoard(int bno) {
		log.info("deleteBoard completed");
		mapper.delete(bno); //리턴 안하고 실행만하는거다.
		
	}

	@Override
	public void modifyBoard(BoardVO boardVO) {
		log.info("modify completed");
		mapper.modify(boardVO); 
	}
	
	@Override
	public BoardVO getReplyBoard(int bno) {
		log.info("getReplyBoard!!");
		return mapper.redayReply(bno);
	}
	
	@Transactional
	@Override
	public void replyBoard(BoardVO boardVO) { //writeReply
		log.info("reply completed");
		//mapper.reply(boardVO);
		
		// sql문을 따로 작성해서 만들 수 있다. 
		// (컨트롤러에서는 반드시 하나로 작성을하고 서비스든 어디든에서 두개로 나눠지는게 핵심이다.)
		// 컨트롤러에는 복잡하게 표현하면 안되고, 여기서 비지니스 로직을 표현해야한다.
		// 컨트롤러에서는 뷰정도만 보여줘야한다. 그래야 나중에 트랜잭션배울때 
		// -> 이거 붙이는데가 서비스여야지 컨트롤러면 안된다. (@Transactional)
		mapper.updateShape(boardVO);
		mapper.insertReply(boardVO);
	}

	@Override
	public void upHit(BoardVO boardVO) {
		log.info("upHit completed");
		mapper.hitUpdate(boardVO);
		
	}

	

}
