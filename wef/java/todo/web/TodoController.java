package biz.todo.web;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import biz.todo.service.TodoService;
import biz.todo.service.TodoVO;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;

@Controller
public class TodoController {
	
	@Resource(name="TodoService")
	TodoService todoService;
	
	@RequestMapping(value="/biz/todo/selectTodoList.do")
	public String selectTodoList(ModelMap model) {
		
		// TODO: 페이징 처리 (Pagination)
		List<?> todoList = todoService.selectTodoList();
		model.addAttribute("todoList", todoList);
		
		// TODO: 타이틀 메시지 처리
		// TODO: 코드데이터 바인딩
		
		return "biz/todo/TodoList";
	}
	
	@RequestMapping(value="/biz/todo/selectTodoVw.do")
	public String selectTodoVw(ModelMap model, @RequestParam("todoId") String todoId) {
		
		TodoVO todoVO = new TodoVO();
		todoVO.setTodoId(todoId);
		todoVO = todoService.selectTodo(todoVO);
		model.addAttribute("todo", todoVO);
		
		return "biz/todo/TodoDtl";
	}
	
	@RequestMapping(value="/biz/todo/insertTodoVw.do")
	public String insertTodoVw(ModelMap model, @ModelAttribute("TodoVO") TodoVO todoVO) {
		
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("userId", user.getId());
		
		return "biz/todo/TodoIns";
	}
	
	@RequestMapping(value="/biz/todo/insertTodo.do")
	public String insertTodo(ModelMap model, @ModelAttribute("TodoVO") TodoVO todoVO) {
		
		// TODO: SEQUENCE로 변경
		todoVO.setTodoId(UUID.randomUUID().toString().substring(0, 20));
		
		// TODO: Validate
		todoService.insertTodo(todoVO);
		
		return "forward:/biz/todo/selectTodoList.do";
	}
	
	@RequestMapping(value="/biz/todo/deleteTodo.do")
	public String deleteTodo(ModelMap model, @RequestParam("todoId") String todoId) {
	
		TodoVO todoVO = new TodoVO();
		todoVO.setTodoId(todoId);
		// TODO: Transaction
		todoService.deleteTodo(todoVO);
		
		return "forward:/biz/todo/selectTodoList.do";
	}
	
	// TODO: DONE으로 업데이트 하는 구조만들기
}
