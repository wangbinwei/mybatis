package com.kuang.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author wbw
 * @date 2021/5/14 16:35
 */
@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student> students;

}
