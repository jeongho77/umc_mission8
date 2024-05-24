package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "gender", length = 50)
    private String gender;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @ColumnDefault("0")
    @Column(name = "point")
    private Long point;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 50)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area")
    private UlsanArea area;

    @ColumnDefault("0")
    @Column(name = "alarmset")
    private Integer alarmset;

    @ColumnDefault("0")
    @Column(name = "reviewset")
    private Integer reviewset;

    @ColumnDefault("0")
    @Column(name = "qnaset")
    private Integer qnaset;

}