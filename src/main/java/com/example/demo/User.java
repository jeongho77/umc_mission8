package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area")
    private UlsanArea area;

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

    @ColumnDefault("0")
    @Column(name = "alarmset")
    private Integer alarmset;

    @ColumnDefault("0")
    @Column(name = "reviewset")
    private Integer reviewset;

    @ColumnDefault("0")
    @Column(name = "qnaset")
    private Integer qnaset;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private Set<Alarm> alarms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private Set<Likefood> likefoods = new LinkedHashSet<>();

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private Set<MissionChallenge> missionChallenges = new LinkedHashSet<>();

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private Set<MissionSuscess> missionSuscesses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private Set<Qna> qnas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private Set<Review> reviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
    private Set<UserDelete> userDeletes = new LinkedHashSet<>();

}