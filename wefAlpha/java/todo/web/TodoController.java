package biz.todo.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springmodules.validation.commons.DefaultBeanValidator;

import biz.todo.service.TodoService;
import biz.todo.service.TodoVO;
import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

@Controller
public class TodoController {
	
	@Resource(name="TodoService")
	TodoService todoService;
	
	@Resource(name="egovTodoIdGnrService")
	private EgovIdGnrService egovTodoIdGnrService;
	
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	@RequestMapping(value="/biz/todo/selectTodoList.do")
	public String selectTodoList(ModelMap model, HttpServletRequest request) {
		
		// TODO: 페이징 처리 (Pagination)
		List<?> todoList = todoService.selectTodoList();
		model.addAttribute("todoList", todoList);
		
		// TODO: 타이틀 메시지 처리
		model.addAttribute("title", egovMessageSource.getMessage("bizTodo.title.Todo", (Locale)request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME)));
		
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
	public String insertTodoVw(ModelMap model, @ModelAttribute("TodoVO") TodoVO todoVO) throws InvocationTargetException, IOException, SQLException {
		
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("userId", user.getId());
		
		// TODO: 코드데이터 바인딩
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCodeId("TODO01");
		List<?> category_list = cmmUseService.selectCmmCodeDetail(vo);
		
		model.addAttribute("category_list", category_list);
		
		return "biz/todo/TodoIns";
	}
	
	@RequestMapping(value="/biz/todo/insertTodo.do")
	public String insertTodo(ModelMap model, @ModelAttribute("TodoVO") TodoVO todoVO,
			BindingResult bindingResult) throws FdlException {
		
		// TODO: SEQUENCE로 변경
		todoVO.setTodoId(egovTodoIdGnrService.getNextStringId());
		//todoVO.setTodoId(UUID.randomUUID().toString().substring(0, 20));
		
		// TODO: Validate
		beanValidator.validate(todoVO, bindingResult);
		if(bindingResult.hasErrors()) {
			return "forward:/biz/todo/selectTodoList.do";
		}
		
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
