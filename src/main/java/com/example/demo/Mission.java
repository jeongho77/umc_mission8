package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "mission")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_number")
    private Restaurant restaurantNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area")
    private UlsanArea area;

    @Column(name = "point")
    private Integer point;

    @Column(name = "price")
    private Integer price;

    @ColumnDefault("168:00:00")
    @Column(name = "deadline")
    private LocalTime deadline;

    @OneToMany(mappedBy = "missionNumber")
    private Set<Alarm> alarms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "missionNumber")
    private Set<MissionChallenge> missionChallenges = new LinkedHashSet<>();

    @OneToMany(mappedBy = "missionNumber")
    private Set<MissionSuscess> missionSuscesses = new LinkedHashSet<>();

}