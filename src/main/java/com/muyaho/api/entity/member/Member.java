package com.muyaho.api.entity.member;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import com.muyaho.api.entity.BaseTimeEntity;
import com.muyaho.api.entity.todo.Group;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "token", "type"})
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String token;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Group> groups = Lists.newArrayList();

    public Member(String token, MemberType type) {
        this.token = token;
        this.type = type;
    }
}
