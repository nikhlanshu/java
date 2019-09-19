package org.nik.moviereview.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Review {
    private String reviewId;
    private String movieUser;
    private Integer reviewStar;
    private String reviewComment;

}
