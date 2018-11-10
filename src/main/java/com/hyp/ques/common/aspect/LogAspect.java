package com.hyp.ques.common.aspect;


import com.hyp.ques.common.result.Result;
import com.hyp.ques.common.result.ResultCode;
import com.hyp.ques.common.service.ServiceException;
import com.hyp.ques.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author hyp
 * Project name is onlinelearning
 * Include in com.hyp.ol.comon.aspect
 * hyp create at 2018/9/21
 **/
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("@within(org.springframework.stereotype.Service)")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        log.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "logPointCut()", returning = "ret")
    public void doAfter(Object ret) throws Exception {
        log.info("返回值 : " + ret);
    }

    @Around(value = "logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = null;// ob 为方法的返回值
        try {
            ob = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }

    @AfterThrowing(value = "logPointCut()", throwing = "et")
    public void doThrow(Exception et) {
        Result result = new Result();
        if (et instanceof ServiceException) {
            result.setCode(((ServiceException) et).getCode());
            result.setMessage(et.getMessage());
        } else {
            result.setCode(ResultCode.NOT_KNOWN);
            result.setMessage("未知错误");
        }
        log.error(result.toString());
    }

    @Pointcut("execution( * com.hyp..controller.*.*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void logPointWebCut() {
    }

    @Before("logPointWebCut()")
    public void doWebBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("请求地址 : " + request.getRequestURL().toString());
        log.info("HTTP METHOD : " + request.getMethod());
        // 获取真实的ip地址
        log.info("IP : " + IPUtils.getIpAddr(request));
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        log.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
//        logger.info("参数 : " + joinPoint.getArgs());

    }

    @AfterReturning(returning = "ret", pointcut = "logPointWebCut()")// returning的值和doAfterReturning的参数名一致
    public void doWebAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
        log.info("返回值 : " + ret);
    }

    @Around("logPointWebCut()")
    public Object doWebAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        log.info("耗时 : " + (System.currentTimeMillis() - startTime));
        return ob;
    }


}
