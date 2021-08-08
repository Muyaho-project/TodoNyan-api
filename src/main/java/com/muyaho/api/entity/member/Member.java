package com.muyaho.api.entity.member;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.muyaho.api.entity.BaseTimeEntity;
import com.muyaho.api.entity.todo.Group;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @Column(name = "member_id")
    private String memberId;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Group> groupList = Lists.newArrayList();

}
