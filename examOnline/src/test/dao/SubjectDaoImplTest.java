package test.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.SubjectDaoImpl;
import com.entity.Subject;
import com.util.Page;
import com.util.PageUtil;

public class SubjectDaoImplTest {
	private static SubjectDaoImpl daoImpl;
	private static Subject subject;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoImpl = new SubjectDaoImpl();
		subject = new Subject();
		subject.setStAnswer("A");//回答
		subject.setStOptionA("我选A");
		subject.setStOptionB("我选B");
		subject.setStOptionC("我选C");
		subject.setStOptionD("我选D");
		subject.setStTitle("下面选项，你选什么:");
		subject.setStParse("C");//答案
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testDeleteByID() {
		daoImpl.deleteByID(1);
	}

	@Test
	public void testFindLikeQueryCount() {
		System.out.println(daoImpl.findLikeQueryCount("下面"));
	}

	@Test
	public void testFindSubjectByID() {
		System.out.println(daoImpl.findSubjectByID(4).getStID());
	}

	@Test
	public void testFindSubjectByTitle() {
		
		Subject subject=daoImpl.findSubjectByTitle("下面选项，你选什么:");
		System.out.println(subject.getStTitle());
	}

	@Test
	public void testFindSubjectCount() {
		System.out.println(daoImpl.findSubjectCount());
	}

	@Test
	public void testFindSubjectsByPage() {
		fail("not");
	}

	@Test
	public void testLikeQueryByTitle() {
		List<Subject> list = daoImpl.likeQueryByTitle("选什么", PageUtil.createPage(5, 5, 0));
		for (Subject subject : list) {
			System.out.println(subject.getStID());
		}
	}

	@Test
	public void testRandomFindSubjects() {
		List<Subject> list = daoImpl.randomFindSubjects(3);
		for (Subject subject : list) {
			System.out.println(subject.getStID());
		}
	}

	@Test
	public void testSave() {
		daoImpl.save(subject);
	}

}
