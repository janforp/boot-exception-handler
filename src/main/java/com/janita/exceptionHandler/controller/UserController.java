package com.janita.exceptionHandler.controller;

import com.janita.exceptionHandler.bean.User;
import com.janita.exceptionHandler.exception.NotFoundException;
import com.janita.exceptionHandler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-25 10:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public User findUser(@PathVariable Long userId){
        User user = userService.findUser(userId);
        if (user == null){
            //在代码中的任何地方都可以抛出自定义异常：CustomExceptionHandler会根据不同的异常类型调用相应的方法处理该异常
            throw new NotFoundException("用户不存在");
        }
        return user;
    }
}
