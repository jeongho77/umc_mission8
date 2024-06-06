package umc.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user_delete")
public class UserDelete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User user_number;

    @Column(name = "deadline")
    private Instant deadline;

}