package test.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.service.TeacherServiceImpl;

public class TeacherServiceImplTest {
	private static TeacherServiceImpl teacherServiceImpl;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		teacherServiceImpl = new TeacherServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAllowLogin() {
		System.out.println(teacherServiceImpl.allowLogin("123456", "wjc#940916"));
	}

}
