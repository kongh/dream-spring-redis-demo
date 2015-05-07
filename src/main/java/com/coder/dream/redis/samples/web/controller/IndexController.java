package com.coder.dream.redis.samples.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/5/7.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping
    public String index(){
        return "index";
    }
}
