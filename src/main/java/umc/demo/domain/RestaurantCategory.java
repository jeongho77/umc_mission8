package umc.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "restaurant_category")
public class RestaurantCategory {
    @Id
    @ColumnDefault("0")
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "category", length = 50)
    private String category;

    @OneToMany(mappedBy = "category_number")
    private Set<Restaurant> restaurants = new LinkedHashSet<>();

}