package test.dao;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.StudentDaoImpl;
import com.entity.Student;
/**
 * 2015年11月23日 13:34:17 测试通过
 * @author Junchuan.Wu
 *
 */
public class StudentDaoImplTest {
	static StudentDaoImpl studentDao ;
	static Student student = new Student();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentDao = new StudentDaoImpl();
		student.setStudentID("1321152232");
		student.setStudentName("吴俊川");
		student.setPassword("wjc#940916");
		student.setResult(100);
		student.setSclass("移动云办公");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void testUpdate(){
		
		studentDao.save(student);
	}
}
