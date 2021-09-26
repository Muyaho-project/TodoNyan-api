package com.muyaho.api.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.muyaho.api.entity.member.Member;
import com.muyaho.api.entity.member.MemberType;
import com.muyaho.api.entity.todo.Group;

@SpringBootTest
@Transactional
class GroupRepositoryTest {

    @Autowired
    GroupRepository groupRepository;

    @Test
    void testGroupRepository() {
        // given
        final Member naverMember = new Member("naverTokenTest", MemberType.NAVER);
        final Group group = new Group(naverMember, 1L, "기본그룹", "#FFFFFF");

        // when
        groupRepository.save(group);
        final Group findGroup = groupRepository.findById(group.getId()).get();

        // then
        assertThat(findGroup.getId()).isEqualTo(group.getId());
        assertThat(findGroup.getMember()).isEqualTo(naverMember);
        assertThat(findGroup).isEqualTo(group);
    }

}