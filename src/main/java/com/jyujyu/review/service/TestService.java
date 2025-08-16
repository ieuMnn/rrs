package com.jyujyu.review.service;

import com.jyujyu.review.model.TestEntity;
import com.jyujyu.review.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TestService {

    // 빨간줄은 어디선가 넣어줘야 하는데 스프링이 자동으로 넣어준다.
    private final TestRepository testRepository;

    public void create(String name, Integer age){
        TestEntity testEntity = new TestEntity(name, age);
        testRepository.save(testEntity);
    }

    public void update(Long id, String name, Integer age){
        TestEntity testEntity = testRepository.findById(id).orElseThrow();
        testEntity.changeNameAndAge(name, age);
        testRepository.save(testEntity);
    }

    public void delete(long id){
        TestEntity testEntity = testRepository.findById(id).get();
        testRepository.delete(testEntity);
    }

    // queryJPA
    public List<TestEntity> findAllByNameByJPA(String name){
        return testRepository.findAllByName(name);
    }

    // querydsl
    public List<TestEntity> findAllByNameByQuerydsl(String name){
        return testRepository.findAllByNameByQuerydsl(name);
    }
}
