package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "mission")
public class Mission {
    @Id
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

}