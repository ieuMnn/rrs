package com.jyujyu.review.service;

import com.jyujyu.review.model.ReviewEntity;
import com.jyujyu.review.repository.RestaurantRepository;
import com.jyujyu.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;

    @Transactional // 생성과 수정에는 트랜잭션을 붙여준다
    public void createReview(Long restaurantId, String content, double score){
        restaurantRepository.findById(restaurantId).orElseThrow();

        ReviewEntity review = ReviewEntity.builder()
                .restaurantId(restaurantId)
                .content(content)
                .createdAt(ZonedDateTime.now())
                .score(score)
                .build();

        reviewRepository.save(review);
    }

    @Transactional
    public void deleteReview(Long reviewId){
        ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();
        reviewRepository.delete(review);

    }
}
