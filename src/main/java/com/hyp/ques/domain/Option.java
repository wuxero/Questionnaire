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
@Table(name = "`q_option`")
public class Option {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 对应题目
     */
    @Column(name = "`s_id`")
    private Long sId;

    /**
     * 顺序
     */
    @Column(name = "`order`")
    private Integer order;

    @Column(name = "`content`")
    private String content;

    @Column(name = "`pic_id`")
    private Long picId;

    /**
     * 分数
     */
    @Column(name = "`score`")
    private Integer score;

    /**
     * 是否计分
     */
    @Column(name = "`scoring`")
    private Boolean scoring;

    /**
     * 说明
     */
    @Column(name = "`tips`")
    private String tips;
}