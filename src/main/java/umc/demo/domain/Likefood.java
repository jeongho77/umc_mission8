package umc.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Likefood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User user_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_number")
    private Food category_number;



    public void setUser(User user_number){
        if(this.user_number != null)
            user_number.getLikefoods().remove(this);
        this.user_number = user_number;
        user_number.getLikefoods().add(this);
    }

    public void setCategory_number(Food category_number){
        this.category_number = category_number;
    }
}