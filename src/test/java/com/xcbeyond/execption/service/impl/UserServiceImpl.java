package com.xcbeyond.execption.service.impl;

import com.xcbeyond.execption.model.User;
import com.xcbeyond.execption.service.UserService;
import com.xcbeyond.execption.util.ExecptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Auther: xcbeyond
 * @Date: 2019/5/28 17:04
 */
@Service
public class UserServiceImpl implements UserService {

    public ResponseEntity login(User user) {
        if (StringUtils.isEmpty(user.getUsername())) {
            throw ExecptionUtils.businessException("EE3001");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            throw ExecptionUtils.businessException("EE3002");
        }

        if (!"xcbeyond".equals(user.getUsername())) {
            throw ExecptionUtils.businessException("EE4001", user.getUsername());
        }

        /**
         * 测试系统级异常.
         * 通过用户名和密码相同时，来模拟网络连接异常
         */
        if (user.getPassword().equals(user.getUsername())) {
            throw ExecptionUtils.systemException("EE9999");
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}