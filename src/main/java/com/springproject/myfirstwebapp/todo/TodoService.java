package com.springproject.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 0; 
	
	static {
		todos.add(new Todo(++todosCount, "Gagan", "Learn SpringBoot", 
				LocalDate.now().plusMonths(1), false));
		todos.add(new Todo(++todosCount, "Gagan", "Learn Communication", 
				LocalDate.now().plusMonths(6), false));
		todos.add(new Todo(++todosCount, "Gagan", "Learn Problem Solving", 
				LocalDate.now().plusMonths(2), false));
	}
	
	public List<Todo> findByUsername(String user) {
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(user);
		List<Todo> userTodos = todos.stream().filter(predicate).toList();
		return userTodos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		todos.add(new Todo(++todosCount, username, description, 
				targetDate, done));
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//		Todo todo = todos.stream().filter(predicate).toList().get(0);
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodoById(int id, Todo todoUpdate) {
		Todo todo = findById(id);
		todo.setDescription(todoUpdate.getDescription());
		todo.setTargetDate(todoUpdate.getTargetDate());
	}
	
}
