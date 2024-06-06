package umc.demo.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.demo.domain.common.BaseEntity;
import umc.demo.domain.mapping.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area")
    private UlsanArea area;

    @Column(name = "name", length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 50)
    private Gender gender;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "specAddress", length = 50)
    private String specAddress;

    @Column(name = "birth")
    private LocalDate birth;

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

    @OneToMany(mappedBy = "user_number", cascade = CascadeType.ALL)
    private List<Alarm> alarms = new ArrayList<>();

    @OneToMany(mappedBy = "user_number", cascade = CascadeType.ALL)
    private List<Likefood> likefoods = new ArrayList<>();

    @OneToMany(mappedBy = "user_number", cascade = CascadeType.ALL)
    private List<MissionChallenge> missionChallenges = new ArrayList<>();

    @OneToMany(mappedBy = "user_number", cascade = CascadeType.ALL)
    private List<MissionSuscess> missionSuscesses = new ArrayList<>();

    @OneToMany(mappedBy = "user_number", cascade = CascadeType.ALL)
    private List<Qna> qnas = new ArrayList<>();

    @OneToMany(mappedBy = "user_number", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user_number", cascade = CascadeType.ALL)
    private List<UserDelete> userDeletes = new ArrayList<>();
}
