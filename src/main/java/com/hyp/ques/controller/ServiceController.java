package com.hyp.ques.controller;

import com.hyp.ques.service.ServicesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客服
 * @author hyp
 * Project name is Questionnaire
 * Include in com.hyp.ques.controller
 * hyp create at 2018/11/10
 **/
@RestController
@RequestMapping("/service")
public class ServiceController {
    @Resource
    private ServicesService servicesService;

}
