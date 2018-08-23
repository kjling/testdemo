package test.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.BaseDao;
import com.dao.BaseDaoImpl;
import com.entity.Teacher;

public class BaseDaoImplTest {
	private static BaseDaoImpl baseDaoImpl;
	private static Teacher teacher;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		baseDaoImpl = new BaseDaoImpl();
		teacher = new Teacher();
		teacher.setTeacherID("admin");
		teacher.setPassword("admin");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSave() {
		baseDaoImpl.save(teacher);
	}

}
