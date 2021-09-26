package com.muyaho.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muyaho.api.entity.todo.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
