package com.jyujyu.review.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter // private 선언했을떄 Getter 추가.
@Builder // 빌더패턴 : id는 DB에서 자동 생성이라 빼고, 나머지를
@AllArgsConstructor // pf
@NoArgsConstructor // 빈 생성자 생성
@Table(name = "restaurant")
@Entity
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void changeNameAndAddress(String name, String address){
        this.name=name;
        this.address=address;
        this.updatedAt=ZonedDateTime.now();
    }
}
