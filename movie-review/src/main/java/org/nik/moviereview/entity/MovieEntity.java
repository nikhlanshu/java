package org.nik.moviereview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MOVIE_DETAILS")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "MOVIE_ID")
    private Integer movieId;
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "GENRE")
    private String genre;
    @Column(name = "REL_DATE")
    private Date relDate;
    @Column(name = "DESCRIPTION")
    private String desc;
}
