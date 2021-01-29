package edu.bit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import jdk.internal.org.jline.utils.Log;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */

@Log4j
@AllArgsConstructor
@Controller
public class BoardController {

	// @Autowired
	private BoardService boardService;
	// 이것도 @Autowired 안적어도 자동 으로 객체 생성. 5버전부터

	// 이제 우리가 했던그 그대로 해보자.
	// 리퀘스트맵핑안하고 4버전부터 알기쉽게 겟맵핑 제공함
	@GetMapping("/list") // 리스트로 들어오면
	public void list(Model model) { // void 이건?
		log.info("list"); // sysout보다 좋음
		model.addAttribute("list", boardService.getList());
		// 어레이리스트- 보드서비스는 인터페이스.구현한거에서 맵퍼(dao)의 겟리스트를 받아옴
		// 받아오면서부터 마이바티스 문법 들어간다. 서비스단에서는 호출(3종세트-> 마이비타스: 이름은 거의 맵퍼)
		// oardService.getList() 이게 어레이리스트 f3들어가면 리스트 나온다.객체 생성되어서 담아옴
	}

	@GetMapping("/write_view")
	public void write_view(Model model) throws Exception  {
		log.info("write_view");
	}

	@PostMapping("/write")
	public String write(BoardVO boardVO, Model model) throws Exception  { // 왠만하면 커맨드객체로 받아내자.
		log.info("write");

		boardService.writeBoard(boardVO);

		return "redirect:list";
	}
	
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) throws Exception { // 왠만하면 커맨드객체로 받아내자.
		log.info("content_view");

		boardService.upHit(boardVO);//
		
		model.addAttribute("content_view", boardService.getBoard(boardVO.getbId()));
		return "content_view";
	}

	@GetMapping("/delete")
	public String delete(BoardVO boardVO, Model model) throws Exception  {
		log.info("delete");

		boardService.deleteBoard(boardVO.getbId());
		return "redirect:list";
	}

	@PostMapping("/modify")
	public String modify(BoardVO boardVO, Model model) throws Exception  {
		log.info("modify");

		boardService.modifyBoard(boardVO);
		return "redirect:list";
	}

	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) throws Exception { 
		log.info("reply_view()");

		model.addAttribute("reply_view", boardService.getReplyBoard(boardVO.getbId()));
		return "reply_view";
	}

	@PostMapping("/reply")
	public String reply(BoardVO boardVO, Model model) throws Exception {
		log.info("reply"); //writeReply

		boardService.replyBoard(boardVO);
		return "redirect:list";
	}

	

}