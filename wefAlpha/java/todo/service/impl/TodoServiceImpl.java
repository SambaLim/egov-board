package biz.todo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import biz.todo.service.TodoService;
import biz.todo.service.TodoVO;

@Service("TodoService")
public class TodoServiceImpl implements TodoService {

	@Resource(name="TodoDAO")
	TodoDAO todoDAO;
	
	@Override
	public List<?> selectTodoList() {
		return todoDAO.selectTodoList();
	}

	@Override
	public TodoVO selectTodo(TodoVO vo) {
		return todoDAO.selectTodo(vo);
	}

	@Override
	public int insertTodo(TodoVO vo) {
		return todoDAO.insertTodo(vo);
	}

	@Override
	public int deleteTodo(TodoVO vo) {
		return todoDAO.deleteTodo(vo);
	}

}
