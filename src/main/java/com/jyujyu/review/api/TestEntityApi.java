package com.jyujyu.review.api;

import com.jyujyu.review.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class TestEntityApi {

    private final TestService testService;

    @PostMapping("/test/entity/create")
    public void createTestEntity(
            @RequestBody CreateTestEntityRequest request
    ){
        testService.create(request.getName(), request.getAge());
    }

    // path variable과 requestBody를 함께 사용.
    // postman 에서 put 할때는 raw 선택, Text>JSON 옵션 변경 해주기.***
    @PutMapping("/test/entity/{id}")
    public void putTestEntity(
        @PathVariable Long id,
        @RequestBody CreateTestEntityRequest request) {
        testService.update(id, request.getName(), request.getAge());
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(@PathVariable Long id){
        testService.delete(id);
    }

    @AllArgsConstructor
    @Getter
    public static class CreateTestEntityRequest{
        private final String name;
        private final Integer age;

    }


}
