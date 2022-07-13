package jpabook.mingle.domain.Univ;

import jpabook.mingle.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter

public class UnivCommentLike {

    @Id @GeneratedValue
    @Column(name = "univcomment_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "univpost_id")
    private UnivPost univPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createdAt;
}
