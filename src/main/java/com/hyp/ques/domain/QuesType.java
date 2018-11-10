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
@Table(name = "`q_ques_type`")
public class QuesType {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型名
     */
    @Column(name = "`type`")
    private String type;

    /**
     * 描述
     */
    @Column(name = "`describe`")
    private String describe;
}