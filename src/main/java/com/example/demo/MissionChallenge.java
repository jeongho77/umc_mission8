package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "mission_challenge")
public class MissionChallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User userNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_number")
    private Mission missionNumber;

    @Column(name = "answer_number")
    private Integer answerNumber;

    @ColumnDefault("144:00:00")
    @Column(name = "deadline")
    private LocalTime deadline;

}