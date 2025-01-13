package com.todoapp.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
//@Controller
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount=0;
	static {
		todos.add(new Todo(++todosCount, "in28Minutes", "LearnAws1", LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "in28Minutes", "LearnDevOps1", LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount, "in28Minutes", "LearnMernStack1", LocalDate.now().plusYears(3),false));
		todos.add(new Todo(++todosCount, "in28Minutes", "LearnFullStack1", LocalDate.now().plusYears(4),false));
	}
	
	public List<Todo> findByUsername(String username)
	{
		Predicate<? super Todo> predicate=todo->todo.getUsername().equalsIgnoreCase(username);
		todos.stream().filter(predicate).toList();
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetdate, boolean done)
	{
		Todo todo= new Todo(++todosCount,username,description,targetdate,done);
		todos.add(todo);
		}
	public void deleteById(int id)
	{
		//bean->condition. example:todo->todo.getId==id
		Predicate<? super Todo> predicate=todo->todo.getId()==id;
		todos.removeIf(predicate);
	
}
	public void updateTodo(@Valid Todo todo)
	{
		deleteById(todo.getId());
		todos.add(todo);
	
}

	public static Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate=todo->todo.getId()==id;
		Todo todo= todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
}
