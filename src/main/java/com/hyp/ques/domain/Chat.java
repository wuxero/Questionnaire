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
@Table(name = "`q_chat_record`")
public class Chat {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 客服id
     */
    @Column(name = "`s_id`")
    private Long sId;

    /**
     * 用户id
     */
    @Column(name = "`c_id`")
    private Long cId;

    @Column(name = "`resource_id`")
    private Long resourceId;

    @Column(name = "`is_coustomer`")
    private Boolean isCoustomer;

    /**
     * 时间
     */
    @Column(name = "`time`")
    private Long time;

    /**
     * 内容
     */
    @Column(name = "`content`")
    private String content;
}