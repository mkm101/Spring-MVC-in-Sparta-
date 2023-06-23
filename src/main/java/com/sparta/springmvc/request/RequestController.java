package com.sparta.springmvc.request;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request")
public class RequestController {
    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // [Request sample]
// GET http://localhost:8080/hello/request/star/Robbie/age/95
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95 , query String방식으로 시작할때, 앞에는 key뒤에는 value
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// POST http://localhost:8080/hello/request/form/param
// Header
//  Content type: application/x-www-form-urlencoded
// Body
//  name=Robbie&age=95 <- Query String, 이러한 데이터를 Request param으로 받을 수 있다.
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }


    // [Request sample]
// POST http://localhost:8080/hello/request/form/model
// Header
//  Content type: application/x-www-form-urlencoded
// Body
//  name=Robbie&age=95 QUERY형식으로 데이터가 들어올 경우
    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }
    // Body부분에 들어온 QueryString 데이터 방식을 객체에 Mapping해서 가져올수 있다.
    // 자동으로 객체로 Mapping 될 수 있다.

    // [Request sample]
// GET http://localhost:8080/hello/request/form/param/model?name=Robbie&age=95
    @GetMapping("/form/param/model")
    @ResponseBody
    public String helloRequestParam(@ModelAttribute Star star) {
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
    }

    //@ModelAttribue와 , @RequestParam 생략가능
    // 스프링은 해당 파라미터들을, Simplevalue 타입이면, request type으로 판정
    // 아니면,직접 만든 클래스들은 ModelAttribute 타입으로 정함.

    // [Request sample]
// POST http://localhost:8080/hello/request/form/json
// Header
//  Content type: application/json
// Body
//  {"name":"Robbie","age":"95"} // JSON형식으로 들어올 경우
    @PostMapping("/form/json")
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }
    // @RequestBody HTTP BODY부분에 JSON형식으로 데이터를 받아왔을때, Request 바디를 달아줘야,
    // 데이터를 객체로 처리할 수 있다.
















}