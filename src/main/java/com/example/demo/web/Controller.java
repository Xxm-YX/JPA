package com.example.demo.web;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private UserDao userDao;

    @GetMapping("/hello/{id}")
    public UserDO hello(@PathVariable("id") Long id){
        return userDao.getById(id);
    }

    @GetMapping("/aaa")
    public Page<UserDO> h(){
        return userDao.findAll(PageRequest.of(0,2));
    }


}
