package com.muyaho.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muyaho.api.entity.todo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
