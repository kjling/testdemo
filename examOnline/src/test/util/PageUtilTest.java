package test.util;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.util.Page;
import com.util.PageUtil;

public class PageUtilTest {
	private static Page page;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		page = PageUtil.createPage(10, 121, 3);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	public void testCreatePage() {
		//测试通过
		System.out.println("beginIndex:"+page.getBeginIndex()+" \ncurrentPage:"+page.getCurrentPage()+"\neveryPage:"+page.getEveryPage());
		System.out.println("totalCount:"+page.getTotalCount());
		System.out.println("totalPage:"+page.getTotalPage());
	}

	@Test
	public void testGetEveryPage() {
	}

	@Test
	public void testGetCurrenPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBeginIndex() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHasPrePage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHasNextPage() {
		fail("Not yet implemented");
	}

}
