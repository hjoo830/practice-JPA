package com.example.jpa.member.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Grade grade;

    protected Member() {}

    public Member(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Grade getGrade() { return grade; }

    public void changeGrade(Grade grade) {
        this.grade = grade;
    }
}
