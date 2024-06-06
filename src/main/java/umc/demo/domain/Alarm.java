package umc.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "alarm")
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "create_date")
    private Instant createDate;

    @Lob
    @Column(name = "text")
    private String text;

//    //실패
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "restaurant_id")
//    private Restaurant restaurant_id;

    //성공
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_number")
    private Restaurant restaurant_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User user_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_number")
    private Mission mission_number;


}