package com.coder.dream.redis.samples.web.controller;

import com.coder.dream.redis.samples.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Administrator on 2015/5/11.
 */
@Controller
@RequestMapping(value = "/cache")
public class CacheController {

    @Autowired
    private RedisCacheManager cacheManager;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public User test(){
        Cache cache = cacheManager.getCache("userCaches");
        Cache.ValueWrapper wrapper = cache.get(2);
        if(wrapper != null){
            return (User)wrapper.get();
        }

        //cache
        User user = new User();
        user.setId(2);
        user.setName("konffffff");
        user.setPassword("fffffffffffffff");
        cache.put(user.getId(),user);

        return user;
    }
}
