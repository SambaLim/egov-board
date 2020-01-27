package biz.todo.service;

import java.util.List;

public interface TodoService {
	
	List<?> selectTodoList();
	TodoVO selectTodo(TodoVO vo);
	int insertTodo(TodoVO vo);
	int deleteTodo(TodoVO vo);
}
