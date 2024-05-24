package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "restaurant_category")
public class RestaurantCategory {
    @Id
    @ColumnDefault("0")
    @Column(name = "number", nullable = false)
    private Integer id;

    @Column(name = "category", length = 50)
    private String category;

}