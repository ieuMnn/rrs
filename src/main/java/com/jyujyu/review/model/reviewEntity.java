package com.jyujyu.review.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="review")
@Entity
public class reviewEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer restaurant_id;
    private String content;
    private Long score;
    private ZonedDateTime create_at;
}
