package umc.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Time;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "mission_challenge")
public class MissionChallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "answer_number")
    private Integer answer_number;

    @Column(name = "deadline")
    private Time deadline = Time.valueOf("144:00:00");

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User user_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_number")
    private Mission mission_number;
}