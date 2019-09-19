package org.nik.moviereview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "review")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MovieReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id", nullable = false, updatable = false, unique = true)
    private String reviewId;
    @Column(name = "user_id", nullable = false, unique = false, length = 10)
    private String userId;
    @Column(name = "review_star", nullable = false, updatable = true, unique = false)
    private Integer reviewStar;
    @Column(name = "review_comment", nullable = false, updatable = true, unique = false, length = 100)
    private String reviewComment;
    @Column(name = "movie_id", unique = false, updatable = false, nullable = false)
    private Integer movieId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movieId")
    private Set<MovieEntity> movies;

}
