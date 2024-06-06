package umc.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Time;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "point")
    private Integer point;

    @Column(name = "price")
    private Integer price;

    @Column(name = "deadline")
    private Time deadline = Time.valueOf("168:00:00");

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_number")
    private Restaurant restaurant_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area")
    private UlsanArea area;

    @OneToMany(mappedBy = "mission_number")
    private Set<Alarm> alarms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "mission_number")
    private Set<MissionChallenge> missionChallenges = new LinkedHashSet<>();

    @OneToMany(mappedBy = "mission_number")
    private Set<MissionSuscess> missionSuscesses = new LinkedHashSet<>();



}