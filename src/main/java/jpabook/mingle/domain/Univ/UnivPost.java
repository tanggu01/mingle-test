package jpabook.mingle.domain.Univ;

import jpabook.mingle.domain.PostCategory;
import jpabook.mingle.domain.PostCommentStatus;
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

public class UnivPost {

    @Id @GeneratedValue
    @Column(name = "univpost_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "univPost")
    private List<UnivComment> postUnivcomments = new ArrayList<>();

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
