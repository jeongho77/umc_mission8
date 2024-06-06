package umc.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "qna_image")
public class QnaImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @ColumnDefault("0")
    @JoinColumn(name = "qna_number")
    private Qna qna_number;

    @Lob
    @Column(name = "image")
    private String image;

}