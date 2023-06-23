package com.sparta.springmvc.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response/rest")
public class ResponseRestController {
    // [Response header]
    //   Content-Type: text/html
    // [Response body]
    //   {"name":"Robbie","age":95}
    @GetMapping("/json/string")
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // [Response header]
    //   Content-Type: application/json
    // [Response body]
    //   {"name":"Robbie","age":95}

    //RestController를 사용하면, RequestBody를 사용하지 않아도됨
    // View를(HTML) 반환해야할 경우 Controller을 달아줘야함
    // JSON 데이터를 반환하는 경우 RequestBody를 안달아줘도됨
    @GetMapping("/json/class")
    public Star helloClassJson() {
        return new Star("Robbie", 95);
    }
}