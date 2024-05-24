package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ulsan_area")
public class UlsanArea {
    @Id
    @Column(name = "number", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "area", nullable = false, length = 50)
    private String area;

}