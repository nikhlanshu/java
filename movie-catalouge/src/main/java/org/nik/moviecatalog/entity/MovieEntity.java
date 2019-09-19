package org.nik.moviecatalog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MOVIE_DETAILS")
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

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getRelDate() {
        return relDate;
    }

    public void setRelDate(Date relDate) {
        this.relDate = relDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", genre='" + genre + '\'' +
                ", relDate=" + relDate +
                ", desc='" + desc + '\'' +
                '}';
    }
}
