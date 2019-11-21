package com.sxf.dao;

import com.sxf.po.Student;
import com.sxf.utils.Hibernateutils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author 凡
 * @create 2019-11-21-11:03
 */
public class Studentdaoimpl implements Studentdao{

    public List<Student> selectAll() {
        //1.获取session
        Session session= Hibernateutils.getSession();
        //2.创建hql语句
        String hql = "from com.sxf.po.Student";
        //3.创建query对象
        Query query = session.createQuery(hql);
        //4.进行查询
        List<Student> list = query.list();
        //5.关闭
        Hibernateutils.closeSession();
        return list;
    }
    public List<Student> selectQueryAll() {
        //1.创建hql语句
        String hql = "from com.sxf.po.Student";
        //2.创建query对象
        Query query =Hibernateutils.getQuery(hql);
        //3.进行查询
        List<Student> list = query.list();
        //4.关闭
        Hibernateutils.closeSession();
        return list;

    }
}
