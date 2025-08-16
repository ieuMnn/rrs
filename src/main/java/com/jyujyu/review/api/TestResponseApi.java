package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResponseApi {

    @GetMapping("/test/response/string")
    public String stringResponse(){
        return "This is String";
    }

    @GetMapping("test/response/json")
    public TestResponseBody jsonResponse(){
        //return "{ \"name\" : \"This is Json\" }";
        return new TestResponseBody("jj", 30);
    }

    // responseBody에는 1. 이너클래스 추가 (for. text/plain > json)
    // 2. 생성자와 getter 필수
    public static class TestResponseBody{
        String name;
        Integer age;

        public TestResponseBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }

}
