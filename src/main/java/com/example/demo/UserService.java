package com.example.demo;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserService {

    @RequestMapping(value = "/user",method= RequestMethod.GET)
    public Object Userinfo(HttpServletRequest request,@RequestHeader String userid){

       // User user =new User(request.getHeader("userid"),222);
        User user =new User(userid,222);
        return user;
    }
}
