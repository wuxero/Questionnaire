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
@Table(name = "`q_questionnaire`")
public class Questionnaire {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`s_id`")
    private Long sId;

    /**
     * 问卷类型
     */
    @Column(name = "`type`")
    private Integer type;

    /**
     * 标题
     */
    @Column(name = "`title`")
    private String title;

    @Column(name = "`time`")
    private Long time;

    /**
     * 0为未发布，1已发布，2撤回
     */
    @Column(name = "`status`")
    private Integer status;

    @Column(name = "`del_flag`")
    private Byte delFlag;

    /**
     * 描述
     */
    @Column(name = "`describe`")
    private String describe;
}