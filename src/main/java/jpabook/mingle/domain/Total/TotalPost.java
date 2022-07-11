package jpabook.mingle.domain.Total;

import jpabook.mingle.domain.PostCategory;
import jpabook.mingle.domain.PostCommentStatus;
import jpabook.mingle.domain.Univ.UnivPost;
import jpabook.mingle.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class TotalPost {

    @Id @GeneratedValue
    @Column(name = "totalpost_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "totalPost")
    private List<TotalComment> postTotalcomments = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private PostCategory postCategory; //enum


    private String title;//글자수제한
    private String content; //글자수제한


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


    private boolean isAnonymous;

    @Enumerated(EnumType.STRING)
    private PostCommentStatus postCommentStatus;


}
