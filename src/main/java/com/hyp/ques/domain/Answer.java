package com.hyp.ques.domain;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by Mybatis Generator on 2018/11/10
*/
@ApiModel
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`q_answer`")
public class Answer {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`q_id`")
    private Long qId;

    @Column(name = "`c_id`")
    private Long cId;

    @Column(name = "`time`")
    private Long time;
}