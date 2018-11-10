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
@Table(name = "`q_resource`")
public class Resource {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`created_date`")
    private Long createdDate;

    @Column(name = "`modified_date`")
    private Long modifiedDate;

    @Column(name = "`path`")
    private String path;

    @Column(name = "`relative_path`")
    private String relativePath;

    @Column(name = "`save_name`")
    private String saveName;

    @Column(name = "`size`")
    private Long size;

    @Column(name = "`type`")
    private String type;

    @Column(name = "`md5value`")
    private String md5value;
}