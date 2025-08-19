package com.jyujyu.review.api.response;

import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantDetailView {

    private final Long id;
    private final String name;
    private final String address;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
    private final List<Menu> menus;

    //이너클래스
    @Getter
    @Builder
    @AllArgsConstructor
    public static class Menu{
        private final Long id;
        private final String name;
        private final Integer price;
        private final ZonedDateTime createdAt;
        private final ZonedDateTime updatedAt;
    }
}
