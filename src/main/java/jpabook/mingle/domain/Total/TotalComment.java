package jpabook.mingle.domain.Total;

import jpabook.mingle.domain.PostCommentStatus;
import jpabook.mingle.domain.Univ.UnivPost;
import jpabook.mingle.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter

public class TotalComment {

    @Id @GeneratedValue
    @Column(name = "totalcomment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "totalpost_id")
    private TotalPost totalPost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String content;

    private Long parent_comment_id;

    /** 익명방법? */
    private boolean isAnonymous;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @Enumerated(EnumType.STRING)
    private PostCommentStatus status;



}
