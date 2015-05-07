package com.coder.dream.redis.samples.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/5/7.
 */
@Controller
@RequestMapping(value = "/")
public class SignInController {

    @RequestMapping(value = "/signIn")
    public String signIn(String name,String password){
        return "main";
    }
}
