package umc.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "qna")
public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "title", length = 50)
    private String title;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "create_time")
    private Instant create_time;

    @Column(name = "qna_answer", length = 50)
    private String qna_answer;

    @OneToMany(mappedBy = "qna_number")
    private Set<QnaImage> qnaImages = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_number")
    private User user_number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_number")
    private QnaCategory category_number;

}