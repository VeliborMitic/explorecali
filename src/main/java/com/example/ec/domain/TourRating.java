package com.example.ec.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by Ext-MayukhG on 7/31/2018.
 */
@Entity
public class TourRating {
    @EmbeddedId
    private TourRatingPk pk;
    @Column(nullable = false)
    private Integer score;
    @Column
    private String comment;

    public TourRating(TourRatingPk pk, Integer score, String comment) {
        this.pk = pk;
        this.score = score;
        this.comment = comment;
    }

    protected TourRating() {
    }

    public TourRatingPk getPk() {
        return pk;
    }

    public String getComment() {
        return comment;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "TourRating{" +
                "pk=" + pk +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }
}
