import com.sxf.po.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author 凡
 * @create 2019-11-20-10:08
 */
public class Test {
    //会话工厂
    private SessionFactory  sessionFactory;
    //会话
    private Session session;
    //事务
    private Transaction tx;
    @org.junit.Before
    public void before(){
     Configuration configuration=new Configuration().configure();
     //会话工厂
     sessionFactory=configuration.buildSessionFactory();
     //生产会话
     session=sessionFactory.openSession();
     //开启事务
     tx=session.beginTransaction();
    }
    @org.junit.Test
    public void test(){
        //获取SessionFactory 会话工厂
        //SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        //生产会话 通过opensession 获取session对象
        //Session session=sessionFactory.openSession();
        //开启事务
        //Transaction transaction = session.beginTransaction();
        //执行查询 get(要查询的实体类型，参数)
        Student student = session.get(Student.class, 1);
        System.out.println("student="+student);
        Student student1 = session.get(Student.class, 1);
        System.out.println("student1="+student1);
        //hql
        String hql="from Student where id=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,1);
        Object o = query.uniqueResult();
        System.out.println("o="+o);
        //查询全部
        Query query1= session.createQuery("from Student");
        List<Student> list=query1.list();
        for (Student stu : list) {
            System.out.println("stu="+stu);
        }
        SQLQuery sqlQuery = session.createSQLQuery("select * from student");
        sqlQuery.addEntity(Student.class);
        List<Student> list1=sqlQuery.list();
        for (Student stu2 : list1) {
            System.out.println(stu2);
        }
        //transaction.commit();//提交事务
        //session.close();//关闭session
        //session=sessionFactory.openSession();
        //transaction=session.beginTransaction();
    }
    @org.junit.Test
    public void testinsert(){
        Student stu=new Student();
        stu.setName("白八");
        session.save(stu);
    }
    @org.junit.Test
    public void testdelete(){
        Student stu=session.get(Student.class,12);
        if(stu!=null){
            session.delete(stu);
        }
    }

    /**
     * saverorupdate 根据主键进行查询 如果查询到数据执行修改操作
     * 否则 执行增加操作
     */
    @org.junit.Test
    public void testupdate(){
        Student stu=new Student();
        stu.setId(11);
        stu.setName("(*￣︶￣*)");
        session.update(stu);
    }
    @org.junit.After
    public void after(){
        tx.commit();
        session.close();
    }
}
