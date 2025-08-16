package com.jyujyu.review.repository;

import com.jyujyu.review.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom {

    // 1) jpa를 이용하여 조건문 select 만들기
    public List<TestEntity> findAllByName(String name);

}
