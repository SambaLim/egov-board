package biz.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import biz.todo.service.TodoVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("TodoDAO")
public class TodoDAO extends EgovComAbstractDAO {

	public List<?> selectTodoList() {
		return selectList("selectTodoList");
	}
	
	public TodoVO selectTodo(TodoVO vo) {
		return (TodoVO)selectOne("selectTodo", vo);
	}
	
	public int insertTodo(TodoVO vo) {
		return insert("insertTodo", vo);
	}
	
	public int deleteTodo(TodoVO vo) {
		return delete("deleteTodo", vo);
	}
}
