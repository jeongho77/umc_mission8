package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "likefood")
public class Likefood {
    @Id
    @Column(name = "number", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User userNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_number")
    private Food categoryNumber;

}