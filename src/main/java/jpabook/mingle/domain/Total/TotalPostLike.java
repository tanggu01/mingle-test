package jpabook.mingle.domain.Total;

import jpabook.mingle.domain.Univ.UnivPost;
import jpabook.mingle.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter

public class TotalPostLike {

    @Id @GeneratedValue
    @Column(name = "totalpost_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "totalpost_id")
    private TotalPost totalPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createdAt;

}
