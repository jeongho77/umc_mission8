package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ulsan_area")
public class UlsanArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @Column(name = "area", nullable = false, length = 50)
    private String area;

    @OneToMany(mappedBy = "area")
    private Set<Mission> missions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "area")
    private Set<User> users = new LinkedHashSet<>();

}