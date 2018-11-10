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
@Table(name = "`q_subject`")
public class Subject {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`q_id`")
    private Long qId;

    /**
     * 次序
     */
    @Column(name = "`order`")
    private Integer order;

    /**
     * 0单选，1多选
     */
    @Column(name = "`type`")
    private Integer type;

    /**
     * 提示
     */
    @Column(name = "`tips`")
    private String tips;

    /**
     * 是否是必答题
     */
    @Column(name = "`is_must`")
    private Boolean isMust;
}