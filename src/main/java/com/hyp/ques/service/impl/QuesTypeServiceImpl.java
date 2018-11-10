package com.hyp.ques.service.impl;

import com.hyp.ques.common.service.AbstractService;
import com.hyp.ques.domain.QuesType;
import com.hyp.ques.service.QuesTypeService;
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
public class QuesTypeServiceImpl extends AbstractService<QuesType>
        implements QuesTypeService {
}
