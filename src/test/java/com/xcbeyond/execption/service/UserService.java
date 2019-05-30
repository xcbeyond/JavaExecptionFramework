package com.xcbeyond.execption.service;

import com.xcbeyond.execption.model.User;
import org.springframework.http.ResponseEntity;

/**
 * @Auther: xcbeyond
 * @Date: 2019/5/28 17:03
 */
public interface UserService {
    ResponseEntity login(User user);
}
