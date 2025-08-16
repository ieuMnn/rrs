package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.*;


@RestController
public class TestRequestApi {

    @GetMapping("/test/param")
    public String requestParam(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age
    ){
        return "Hello, Request Param :" + name + ", " + age;
    }

    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age
    ){
        return "Hello, Request Path : " + name + ", " + age;
    }

    // requestBody 에서는 주로 post 또는 put 맵핑을 사용함.
    @PostMapping("/test/body")
    public String requestBody(
            @RequestBody TestRequestBody request
    ){
        return "Hello, Request Body : " + request.name + ", " + request.age;
    }
    // requestBody 사용할때는 1. 이너클래스 2. 생성자 꼭 필요함 안그러면 400 에러난다.
    public static class TestRequestBody{
        String name;

        Integer age;

        public TestRequestBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

}
