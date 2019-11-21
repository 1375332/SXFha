package com.sxf.dao;

import com.sxf.po.Student;

import java.util.List;

/**
 * @author 凡
 * @create 2019-11-21-11:04
 */
public interface Studentdao {

    List<Student> selectAll();
}
