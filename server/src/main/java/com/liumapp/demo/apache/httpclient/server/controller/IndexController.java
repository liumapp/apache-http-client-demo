package com.liumapp.demo.apache.httpclient.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String params () {
        return "success";
    }

}
