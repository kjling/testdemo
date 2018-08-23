package com.util;

/**
 * Created by Junchuan.Wu on 2015/10/30 0030.
 * 实现数据检验
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据检验类
 *
 * @author Junchuan.Wu
 */
public class DataValidator {

    /**
     * 验证字符串是否为空="" or null
     *
     * @param input 输入要验证的字符串
     * @return boolean 返回true or false
     */
    public static boolean isNullEmpty(String input) {
        return "".equals(input) || input == null;
    }

    /**
     * 匹配正则表达式
     */
    public static boolean regaxMatch(String input, String pattern) {
        if (isNullEmpty(input)) {
            return false;
        } else {
            return Pattern.compile(pattern).matcher(input).matches();
        }
    }

    /**
     * HTML编码，支持换行符
     *
     * @param input
     * @return
     */
    public static String htmlEncode(String input) {
        if (!DataValidator.isNullEmpty(input)) {
            input = input.replace("&", "&amp;");
            input = input.replace("<", "&lt;");
            input = input.replace(">", "&gt;");
            input = input.replace("'", "&#39;");
            input = input.replace("\"", "&quot;");
            input = input.replace("\n\r", "<br>;");
            input = input.replace("\n", "<br>;");
        }
        return input;
    }

    /**
     * HTML反编码 支持换行符
     *
     * @param input
     * @return
     */
    public static String htmlDecode(String input) {

        if (!DataValidator.isNullEmpty(input)) {
            input = input.replace("&amp;", "&");
            input = input.replace("&lt;", "<");
            input = input.replace("&gt;", ">");
            input = input.replace("&#39;", "'");
            input = input.replace("&quot;", "\"");
            input = input.replace("<br>;", "\n\r");
            input = input.replace("<br>;", "\n");
        }
        return input;
    }

    /**
     * HTML编码，不支持换行符
     *
     * @param input
     * @return
     */
    public static String serverHtmlEncode(String input) {
        if (DataValidator.isNullEmpty(input)) {
            return input;
        }
        input = input.replace("&amp;", "&");
        input = input.replace("&lt;", "<");
        input = input.replace("&gt;", ">");
        input = input.replace("&#39;", "'");
        input = input.replace("&quot;", "\"");
        return input;
    }

    /**
     * HTML反编码，不支持换行符
     *
     * @param input
     * @return
     */
    public static String serverHtmlDecode(String input) {
        if (DataValidator.isNullEmpty(input)) {
            return input;
        }
        input = input.replace("&amp;", "&");
        input = input.replace("&lt;", "<");
        input = input.replace("&gt;", ">");
        input = input.replace("&#39;", "'");
        input = input.replace("&quot;", "\"");
        return input;
    }

    /**
     * 过滤所有的HTML代码
     *
     * @param input
     * @return
     */
    public static String removeHtml(String input) {
        if (!DataValidator.isNullEmpty(input)) {
            return input;
        }
        Pattern p = Pattern.compile("<[^>]*>", Pattern.MULTILINE | Pattern.UNICODE_CASE);
        Matcher m = p.matcher(input);
        return m.replaceAll("");
    }
}