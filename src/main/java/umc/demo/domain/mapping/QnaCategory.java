package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "qna_category")
public class QnaCategory {
    @Id
    @Column(name = "number", nullable = false)
    private Integer id;

    @Column(name = "category", length = 50)
    private String category;

}