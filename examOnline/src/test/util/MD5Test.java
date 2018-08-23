package test.util;


import java.io.UnsupportedEncodingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.util.MD5;

public class MD5Test {
	private static String a = "~!@#$%^&*()";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void test() throws UnsupportedEncodingException{
		System.out.println(a.getBytes("utf-8"));
		System.out.println(a+":::::"+MD5.Encrypt(a));
	}
	@Test
	public void test2() throws UnsupportedEncodingException{
		byte[] bytelist = a.getBytes("utf-8");
		System.out.println(encodeHex(bytelist));
		
	}
	private static final String encodeHex(byte[] digest) {
        int i;
        StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
        for (i = 0; i < digest.length; i++) {
            if ((int) (digest[i] & 0xff) < 0x10) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Long.toString((int) digest[i] & 0xff, 16));
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
