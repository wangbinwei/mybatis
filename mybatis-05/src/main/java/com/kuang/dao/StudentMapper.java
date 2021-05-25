package com.kuang.dao;

import com.kuang.pojo.Student;

import java.util.List;
import java.util.Map;

/**
 * @author wbw
 * @date 2021/5/16 11:33
 */
public interface StudentMapper {
    //查询所有的学生信息，以及对应的老师信息

    List<Student> queryByName(Map map);

    List<Student> queryByIds(List list);

    int updateById(Student student);
}
