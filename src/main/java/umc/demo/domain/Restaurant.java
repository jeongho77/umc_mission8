package umc.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "opentime")
    private LocalTime opentime;

    @Column(name = "closetime")
    private LocalTime closetime;

    @ColumnDefault("0")
    @Column(name = "opentrigger")
    private Integer opentrigger;

    @OneToMany(mappedBy = "restaurant_number" ,cascade = CascadeType.ALL)
    private Set<Alarm> alarms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "restaurant_number" , cascade = CascadeType.ALL)
    private Set<Mission> missions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "restaurant_number" ,cascade = CascadeType.ALL)
    private Set<RestaurantImage> restaurantImages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "restaurant_number" ,cascade = CascadeType.ALL)
    private Set<Review> reviews = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_number")
    private RestaurantCategory category_number;

}