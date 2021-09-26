package com.muyaho.api.entity.todo;

import static javax.persistence.FetchType.*;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.collect.Lists;

import com.muyaho.api.entity.BaseTimeEntity;
import com.muyaho.api.entity.member.Member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "seq", "name", "color"})
public class Group extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Long seq;

    private String name;

    private String color;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Todo> todos = Lists.newArrayList();

    public Group(Member member, Long seq, String name, String color) {
        this.member = member;
        member.getGroups().add(this);

        this.seq = seq;
        this.name = name;
        this.color = color;
    }
}
