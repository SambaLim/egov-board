package egovframework.com.board.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.board.service.MyBoardService;
import egovframework.com.board.service.MyBoardVO;

@Controller
public class MyBoardController {
	
	@Resource(name="myBoardService")
	public MyBoardService myBoardService;
	
	@RequestMapping(value="/wavus/myboard.do")
	public String selectBoard(ModelMap model) {
		
		List<MyBoardVO> boardList = myBoardService.selectMyBoardList();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("title", "My Board Page");
		model.addAttribute("hello", "Hello, Board!");
		
		return "egovframework/com/board/MyBoardPage";
	}
}