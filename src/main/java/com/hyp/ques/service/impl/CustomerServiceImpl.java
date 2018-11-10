package com.hyp.ques.service.impl;

import com.hyp.ques.common.service.AbstractService;
import com.hyp.ques.domain.Customer;
import com.hyp.ques.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hyp
 * Project name is Questionnaire
 * Include in com.hyp.ques.service.impl
 * hyp create at 2018/11/10
 **/
@Service
@Transactional(rollbackFor = Exception.class, timeout = 1000)
public class CustomerServiceImpl extends AbstractService<Customer> implements CustomerService {
}
