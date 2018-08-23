/**
 * 
 */
package test.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entity.Student;
import com.service.StudentServiceImpl;

/**
 * 2015年11月23日 13:33:53 测试通过
 * @author Junchuan.Wu
 * 
 */
public class StudentServiceImplTest {
	private static StudentServiceImpl studentServiceImpl;
	private static Student student;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentServiceImpl = new StudentServiceImpl();
		student = new Student();
		student.setStudentID("1321152232");
		student.setPassword("wjc#940916");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.service.StudentServiceImpl#allowLogin(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testAllowLogin() {
		boolean b =  studentServiceImpl.allowLogin(student.getStudentID(), student.getPassword());
		System.out.println(b);
	}

	/**
	 * Test method for
	 * {@link com.service.StudentServiceImpl#getStudentByClass(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetStudentByClass() {
	}

	/**
	 * Test method for
	 * {@link com.service.StudentServiceImpl#getStudentByName(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetStudentByName() {
		List<Student> list =studentServiceImpl.getStudentByName("吴俊川1");
		for (Student student : list) {
			System.out.println(student.getStudentName()+"    ");
		}
	}

	/**
	 * Test method for
	 * {@link com.service.StudentServiceImpl#getStudentInfo(java.lang.String)}.
	 */
	@Test
	public void testGetStudentInfo() {
		Student stu = studentServiceImpl.getStudentInfo("1321152232");
		System.out.println(stu);
	}

	/**
	 * Test method for
	 * {@link com.service.StudentServiceImpl#setStudentResult(java.lang.String, int)}
	 * .
	 */
	@Test
	public void testSetStudentResult() {
		studentServiceImpl.setStudentResult("1321152232", 40);
	}

}
