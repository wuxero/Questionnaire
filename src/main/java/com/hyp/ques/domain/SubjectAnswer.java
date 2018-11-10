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
@Table(name = "`q_subject_answer`")
public class SubjectAnswer {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 对应答案id
     */
    @Column(name = "`a_id`")
    private Long aId;

    /**
     * 题目id
     */
    @Column(name = "`s_id`")
    private Long sId;

    /**
     * 选项id
     */
    @Column(name = "`o_id`")
    private Long oId;

    /**
     * 内容
     */
    @Column(name = "`content`")
    private String content;
}