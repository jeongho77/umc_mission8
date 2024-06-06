package umc.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "mission_suscess")
public class MissionSuscess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "point_trigger", length = 50)
    private String pointTrigger;

    @ColumnDefault("current_timestamp()")
    @Column(name = "date")
    private Instant date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_number")
    private Mission mission_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User user_number;
}