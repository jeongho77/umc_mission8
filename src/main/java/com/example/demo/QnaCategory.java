package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "qna_category")
public class QnaCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @Column(name = "category", length = 50)
    private String category;

    @OneToMany(mappedBy = "categoryNumber")
    private Set<Qna> qnas = new LinkedHashSet<>();

}