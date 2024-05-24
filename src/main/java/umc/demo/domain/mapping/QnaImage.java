package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "qna_image")
public class QnaImage {
    @Id
    @Column(name = "number", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @ColumnDefault("0")
    @JoinColumn(name = "qna_number")
    private Qna qnaNumber;

    @Lob
    @Column(name = "image")
    private String image;

}