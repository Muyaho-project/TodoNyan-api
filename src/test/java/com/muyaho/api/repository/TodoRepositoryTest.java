package com.muyaho.api.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.muyaho.api.entity.member.Member;
import com.muyaho.api.entity.member.MemberType;
import com.muyaho.api.entity.todo.Group;
import com.muyaho.api.entity.todo.Todo;

@SpringBootTest
@Transactional
class TodoRepositoryTest {

    @Autowired
    TodoRepository todoRepository;

    @Test
    void testTodoRepository() {
        // given
        final Member naverMember = new Member("naverTokenTest", MemberType.NAVER);
        final Group group = new Group(naverMember, 1L, "기본그룹", "#FFFFFF");
        final Todo todo = new Todo(group, "할일제목", "할일메모");

        // when
        todoRepository.save(todo);
        final Todo findTodo = todoRepository.findById(todo.getId()).get();

        // then
        assertThat(findTodo.getId()).isEqualTo(todo.getId());
        assertThat(findTodo.getGroup()).isEqualTo(group);
        assertThat(findTodo.getGroup().getMember()).isEqualTo(naverMember);
        assertThat(findTodo).isEqualTo(todo);
    }
}