package com.hyp.ques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author hyp
 * Project name is QuestionnaireService
 * Include in com.hyp.ques
 * hyp create at 2018/11/7
 **/
@SpringBootApplication
public class QApplication extends SpringBootServletInitializer {

    // jar启动
    public static void main(String[] args) {
        SpringApplication.run(QApplication.class, args);
    }

    // tomcat war启动
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(QApplication.class);
    }
}
