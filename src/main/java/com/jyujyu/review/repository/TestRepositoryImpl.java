package com.jyujyu.review.repository;

import com.jyujyu.review.model.QTestEntity;
import com.jyujyu.review.model.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
// Impl 구현클래스에 붙여주는 접미사~~
public class TestRepositoryImpl implements TestRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return queryFactory.selectFrom(QTestEntity.testEntity).fetch();
    }
}
