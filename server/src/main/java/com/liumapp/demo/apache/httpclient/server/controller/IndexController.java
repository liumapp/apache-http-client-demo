package com.liumapp.demo.apache.httpclient.server.controller;

import com.liumapp.demo.apache.httpclient.server.pattern.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liumapp on 3/3/18 11:09 AM.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RestController
@RequestMapping("")
public class IndexController {

    @GetMapping("/")
    public String index () {
        return "hello world";
    }

    @PostMapping("/params")
    public String params (@RequestBody User user) {
        return user.toString();
    }

}
