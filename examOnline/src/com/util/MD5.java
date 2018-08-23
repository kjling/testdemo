package com.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 实现密码加密
 */
public class MD5 {
    private static MessageDigest digest = null;

    /**
     * 默认加密为16位
     *
     * @param data
     * @return
     */
    public synchronized static final String Encrypt(String data) {
        return Encrypt(data, 16);
    }

    /**
     * 可以手动设置加密位数
     *
     * @param data
     * @param len
     * @return
     */
    public synchronized static final String Encrypt(String data, int len) {
        if (digest == null) {
            try {
                /*获取一个MD5的转换器*/
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        if (len != 16 && len != 32) len = 16;
        try {
            /*
            1.将输入的字符串转换为utf-8编码的字节数组
            2.Updates the digest
            */
            digest.update(data.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String s = encodeHex(digest.digest());
        if (len == 16) {
            return s.substring(8, 24);
        }
        return s;
    }

    /**
     * 编码为十六进制数
     *
     * @param digest
     * @return
     */
    private static final String encodeHex(byte[] digest) {
        int i;
        StringBuffer stringBuffer = new StringBuffer(digest.length * 2);
        for (i = 0; i < digest.length; i++) {
            if ((int) (digest[i] & 0xff) < 0x10) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Long.toString((int) digest[i] & 0xff, 16));
        }
        return stringBuffer.toString();
    }


}