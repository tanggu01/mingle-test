package jpabook.mingle.domain;

import jpabook.mingle.domain.Total.TotalComment;
import jpabook.mingle.domain.Total.TotalPost;
import jpabook.mingle.domain.Total.TotalPostLike;
import jpabook.mingle.domain.Total.TotalPostScrap;
import jpabook.mingle.domain.Univ.UnivComment;
import jpabook.mingle.domain.Univ.UnivPost;
import jpabook.mingle.domain.Univ.UnivPostLike;
import jpabook.mingle.domain.Univ.UnivPostScrap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "univ_id")
    private UnivName univCategory;

    private String nickName;
    private String email; //regex 추가
    private String pwd; //regex 추가

    /** 학교게시판*/
    @OneToMany(mappedBy = "user")
    private List<UnivPost> userUnivPosts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UnivPostLike> userUnivPostLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UnivPostScrap> userUnivPostScraps = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UnivComment> userUnivComments = new ArrayList<>();

//    private List<UnivCommentLike> univCommentLikes


    /** 전체게시판*/
    @OneToMany(mappedBy = "user")
    private List<TotalPost> userTotalPosts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<TotalPostLike> userTotalPostLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<TotalPostScrap> userTotalPostScraps = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<TotalComment> userTotalComments = new ArrayList<>();


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @Enumerated(EnumType.STRING)
    private Userstatus status;

}
