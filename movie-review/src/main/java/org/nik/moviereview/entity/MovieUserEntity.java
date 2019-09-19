package org.nik.moviereview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="movie_user")
public class MovieUserEntity {
    @Id
    @Column(name="user_id")
    private String userId;
    @Column(name="dob")
    private LocalDate dob;
    @Column(name = "gender")
    private String gender;
}
