package com.muyaho.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muyaho.api.entity.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
