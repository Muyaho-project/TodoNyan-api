package com.muyaho.api.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.muyaho.api.entity.member.Member;
import com.muyaho.api.entity.member.MemberType;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void testMemberRepository() {
        // given
        final Member naverMember = new Member("naverTokenTest", MemberType.NAVER);
        final Member kakaoMember = new Member("kakaoTokenTest", MemberType.KAKAO);

        // when
        memberRepository.save(naverMember);
        memberRepository.save(kakaoMember);

        final Member findNaverMember = memberRepository.findById(naverMember.getId()).get();
        final Member findKakaoMember = memberRepository.findById(kakaoMember.getId()).get();

        // then
        assertThat(findNaverMember.getId()).isEqualTo(naverMember.getId());
        assertThat(findKakaoMember.getId()).isEqualTo(kakaoMember.getId());

        assertThat(findNaverMember).isEqualTo(naverMember);
        assertThat(findKakaoMember).isEqualTo(kakaoMember);
    }

}