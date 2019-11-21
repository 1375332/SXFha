import com.sxf.dao.Studentdao;
import com.sxf.dao.Studentdaoimpl;
import com.sxf.po.Student;

import java.util.List;

/**
 * @author 凡
 * @create 2019-11-21-11:41
 */
public class Teststudentdao {
    @org.junit.Test
    public void teststudentselectall(){
        Studentdao sd=new Studentdaoimpl();
        List<Student> students=((Studentdaoimpl) sd).selectQueryAll();
        for (Student student : students) {
            System.out.println("student="+student);
        }
    }
}
