package com.todoapp.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{ //INteger is type of primary key which is Id
	public List<Todo> findByUsername(String username);//ths will automatically generate a method to fetch the entity with the username by spring jpa
}