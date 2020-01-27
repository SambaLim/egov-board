package biz.todo.service;

public class TodoVO {
	
	private String todoId;
	private String todoCategory;
	private String todoRegister;
	private String todoTitle;
	private String todoDone;
	private String todoDesc;
	
	public String getTodoId() {
		return todoId;
	}
	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}
	public String getTodoCategory() {
		return todoCategory;
	}
	public void setTodoCategory(String todoCategory) {
		this.todoCategory = todoCategory;
	}
	public String getTodoRegister() {
		return todoRegister;
	}
	public void setTodoRegister(String todoRegister) {
		this.todoRegister = todoRegister;
	}
	public String getTodoTitle() {
		return todoTitle;
	}
	public void setTodoTitle(String todoTitle) {
		this.todoTitle = todoTitle;
	}
	public String getTodoDone() {
		return todoDone;
	}
	public void setTodoDone(String todoDone) {
		this.todoDone = todoDone;
	}
	public String getTodoDesc() {
		return todoDesc;
	}
	public void setTodoDesc(String todoDesc) {
		this.todoDesc = todoDesc;
	}
}