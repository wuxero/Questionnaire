package com.hyp.ques.controller;

import com.hyp.ques.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hyp
 * Project name is Questionnaire
 * Include in com.hyp.ques.controller
 * hyp create at 2018/11/10
 **/
@Api(value = "用户",tags = "用户")
@RestController
@RequestMapping("/customer")
public class UserController {
    @Resource
    private CustomerService customerService;

}
