package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_number")
    private Restaurant restaurantNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User userNumber;

    @ColumnDefault("current_timestamp()")
    @Column(name = "create_date")
    private Instant createDate;

    @ColumnDefault("current_timestamp()")
    @Column(name = "update_date")
    private Instant updateDate;

    @Column(name = "text", length = 50)
    private String text;

    @Column(name = "rating")
    private Double rating;

    //1:N 하나의 리뷰에 이미지 3개
    @OneToMany(mappedBy = "number" , cascade = CascadeType.ALL)
    private Set<ReviewImage> reviewImages = new LinkedHashSet<>();

}