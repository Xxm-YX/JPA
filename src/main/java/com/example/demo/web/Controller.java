package com.example.demo.web;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private UserDao userDao;

    @GetMapping("{id}")
    public UserDO hello(@PathVariable("id") Long id){
        return userDao.getById(id);
    }
}
