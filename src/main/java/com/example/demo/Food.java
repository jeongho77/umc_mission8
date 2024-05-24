package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @Column(name = "food", length = 50)
    private String food;

    @OneToMany(mappedBy = "categoryNumber")
    private Set<Likefood> likefoods = new LinkedHashSet<>();

}