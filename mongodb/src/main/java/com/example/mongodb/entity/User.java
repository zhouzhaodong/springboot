package com.example.mongodb.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    /**
     * id主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

}
