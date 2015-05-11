package com.coder.dream.redis.samples.web.controller;

import com.coder.dream.redis.samples.dao.UserRepository;
import com.coder.dream.redis.samples.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    @ResponseBody
    public String create(User user){
        userRepository.save(user);
        return "success";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable Integer id){
        userRepository.delete(id);
        return "success";
    }

    /**
     * 获取一个
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public User get(@PathVariable Integer id){
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<User> list(){
        return userRepository.list();
    }

    @RequestMapping(value = "/page")
    @ResponseBody
    public List<User> page(Integer begin,Integer size){
        return userRepository.page();
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(User user){
        userRepository.test(user);
        return "success";
    }
}
