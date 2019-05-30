package com.xcbeyond.execption.controller;

import com.xcbeyond.execption.model.User;
import com.xcbeyond.execption.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 异常测试Controller。
 * 没有具体的业务逻辑参考，仅用来测试各种异常情况
 * @Auther: xcbeyond
 * @Date: 2019/5/28 16:58
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user) {
        return userService.login(user);
    }
}