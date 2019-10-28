package com.rigid.jpademos.utils;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeList;

import java.util.regex.Pattern;

/**
 * @tool: Created with IntelliJ IDEA
 * @program:
 * @description:
 * @author: Rigid
 * @create: 2019-08-26 11:13
 */
public final class StringUtils extends org.apache.commons.lang.StringUtils {
    private final static String ISO8859_1 = "8859_1";
    private final static String enReg = "^\\w+$";

    private final static NodeFilter nodeFilter = new NodeFilter() {
        private static final long serialVersionUID = 1995670678530709461L;

        @Override
        public boolean accept(Node node) {
            return true;
        }
    };

    public static String getFileExtend(String fn) {
        if (isEmpty(fn)) {
            return null;
        }
        int idx = fn.lastIndexOf('.') + 1;
        if (idx == 0 || idx >= fn.length()) {
            return null;
        }
        return fn.substring(idx);
    }

    /**
     * 检测字符是否为null
     *
     * @param str
     * @return 空返回"" 否则返回源字符串
     */
    public static String checkStr(String str) {
        return str == null || str.length() == 0 || str.equals("null") ? "" : str.trim();
    }

    /**
     * 检测Object是否为null
     *
     * @param obj
     * @return 空返回"" 否则返回源字符串
     */
    public static boolean checkObj(Object obj) {
        return obj == null || obj.equals("null");
    }

    /**
     * 处理带HTML标记字符串
     *
     * @param str
     * @return
     */
    public static String formatNotHtml(String str) {
        if (str == null) {
            return "";
        }
        String randomStr = String.valueOf(System.currentTimeMillis());
        String html = replace(str, "&nbsp;", randomStr);
        html = replace(html, "\"", "&quot;");
        // 替换跳格
        html = replace(html, "\t", "&nbsp;&nbsp;");
        html = replace(html, "<", "&lt;");
        html = replace(html, ">", "&gt;");
        html = replace(html, "\"", "&quot;");
        return replace(html, randomStr, "&nbsp;").trim();
    }

    /**
     * 转换&lt; 成 < 简单的HTML语言
     *
     * @param str
     * @return
     */
    public static String formatHtml(String str) {
        if (str == null) {
            return "";
        }
        String randomStr = String.valueOf(System.currentTimeMillis());
        String html = replace(str, "&nbsp;", randomStr);
        html = replace(html, "&amp;", "&");
        html = replace(html, "&apos;", "'");
        html = replace(html, "&quot;", "\"");
        // 替换跳格
        html = replace(html, "&nbsp;&nbsp;", "\t");
        // 替换空格
        html = replace(html, "&nbsp;", " ");
        html = replace(html, "&lt;", "<");
        html = replace(html, "&gt;", ">");
        html = replace(html, "&#34;", "\"");
        html = replace(html, "&#60;", "<");
        html = replace(html, "&#62;", ">");
        return replace(html, randomStr, "&nbsp;").trim();
    }

    /**
     * 删除空行
     *
     * @param text
     * @return
     */
    public static String delBlankLine(String text) {
        if (text == null || text.length() == 0) return "";
        text = replace(replace(text, "\r", ""), "\n", "");
        return text;
    }

    /**
     * 抽取纯文本信息
     *
     * @param inputHtml
     * @return
     */
    public static String extractText(String inputHtml) throws Exception {
        StringBuffer text = new StringBuffer();
        Parser parser = new Parser();
        parser.setEncoding(ISO8859_1);
        parser.setInputHTML(inputHtml);
        NodeList nodes = parser.extractAllNodesThatMatch(nodeFilter);
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.elementAt(i);
            text.append(node.toPlainTextString());
        }
        return text.toString();
    }

    /**
     * Object 转 String
     *
     * @param obj
     * @return 空返回"" 否则返回源字符串
     */
    public static String obj2Str(Object obj) {
        return obj == null || !(obj instanceof String) ? "" : obj.toString().trim();
    }

    /**
     * double 字符串转整数
     *
     * @param str
     * @return
     */
    public static String formatString(String str) {
        str = str + "";
        if (str.indexOf(".") > 0) {
            str = str.substring(0, str.indexOf("."));
        }
        return str;
    }

    /**
     * 数组转换成字符串
     * 默认以,分割
     *
     * @param data fenge
     * @return
     */
    public static String strArray2Str(String[] data, String fenge) {
        if (data == null) {
            return "";
        }
        if (fenge == null || fenge.equals("")) {
            fenge = ",";
        }
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]).append(fenge);
        }
        if (data.length > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 整数数组转换成字符串
     *
     * @param data
     * @param fenge
     * @return
     */
    public static String intArrayToStr(int[] data, String fenge) {
        if (data == null)
            return "";
        if (fenge == null || fenge.equals(""))
            fenge = ",";
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]).append(fenge);
        }
        if (data.length > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 查询中英文字符串长度
     *
     * @param str
     * @return
     */
    public static int strLen(String str) {
        if (str != null) {
            int num = str.getBytes().length;
            return num / 2 + num % 2;
        }
        return 0;
    }

    /**
     * 字符长度截取，两个字母算一个中文
     *
     * @param str
     * @param len
     * @return
     */
    public static String cutStr(String str, int len) {
        if (str == null || str.equals("")) {
            return "";
        } else if (len > str.length()) {
            return str;
        }
        len = len * 2;
        int cutNum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int code = (int) c;
            if (code > 256) {
                cutNum += 2;
            } else {
                cutNum++;
            }
            if (cutNum > len) {
                return str.substring(0, i).toString().trim();
            }
        }
        return str;
    }

    public static boolean isEnStr(String str) {
        return str.matches(enReg);
    }

    /**
     * 输入的字符是否是汉字
     *
     * @param a char
     * @return boolean
     */
    public static boolean isChinese(char a) {
        int v = (int) a;
        return (v >= 19968 && v <= 171941);
    }

    /**
     * 是否包含中文字符
     **/
    public static boolean containsChinese(String s) {
        if (null == s || "".equals(s.trim())) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isChinese(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是不是一个合法的电子邮件地址
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (email == null) {
            return false;
        }
        email = email.trim();
        if (email.indexOf(' ') != -1) {
            return false;
        }
        int idx = email.indexOf('@');
        if (idx == -1 || idx == 0 || (idx + 1) == email.length()) {
            return false;
        }
        if (email.indexOf('@', idx + 1) != -1) {
            return false;
        }
        if (email.indexOf('.') == -1) {
            return false;
        }
        return true;
    }

    /**
     * 检测是否是电话号码
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        if (phone != null) {
            phone = phone.trim();
            String regex = "^0\\d{2,3}-*\\d{7,8}-*\\d*$";
            return phone.matches(regex);
        }
        return false;
    }

    /**
     * 检测是否是手机号码
     *
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {
        if (mobile != null) {
            mobile = mobile.trim();
            return Pattern.matches("^1[0-9]{10}$", mobile);
        }
        return false;
    }

    /**
     * 判断字符串数组中是否含有指定字符串
     *
     * @param strs
     * @param str
     * @return
     */
    public static boolean stringInArray(String[] strs, String str) {
        if (isEmpty(str) || strs == null) {
            return false;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!isEmpty(strs[i]) && strs[i].equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串是否是一个IP地址
     *
     * @param addr
     * @return
     */
    public static boolean isIPAddr(String addr) {
        if (isEmpty(addr)) {
            return false;
        }
        String[] ips = split(addr, ".");
        if (ips.length != 4) {
            return false;
        }
        try {
            int ipa = Integer.parseInt(ips[0]);
            int ipb = Integer.parseInt(ips[1]);
            int ipc = Integer.parseInt(ips[2]);
            int ipd = Integer.parseInt(ips[3]);
            return ipa >= 0 && ipa <= 255 && ipb >= 0 && ipb <= 255 && ipc >= 0 && ipc <= 255 && ipd >= 0 && ipd <= 255;
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 大小写无关的字符串替换策略
     *
     * @param str
     * @param src
     * @param obj
     * @return
     */
    public static String replaceIgnoreCase(String str, String src, String obj) {
        String l_str = str.toLowerCase();
        String l_src = src.toLowerCase();
        int fromIdx = 0;
        StringBuffer result = new StringBuffer();
        do {
            int idx = l_str.indexOf(l_src, fromIdx);
            if (idx == -1) {
                break;
            }
            result.append(str.substring(fromIdx, idx));
            result.append(obj);
            fromIdx = idx + src.length();
        } while (true);
        result.append(str.substring(fromIdx));
        return result.toString();
    }

    /**
     * 用户名必须是数字或者字母的结合
     *
     * @param username
     * @return
     */
    public static boolean isLegalUsername(String username) {
        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            if (!isAscii(ch) && ch != '.' && ch != '_' && ch != '-' && ch != '+' && ch != '(' && ch != ')' && ch != '*' && ch != '^' && ch != '@' && ch != '%' && ch != '$' && ch != '#' && ch != '~' && ch != '-') {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否是字母和数字的结合
     *
     * @param name
     * @return
     */
    public static boolean isAsciiOrDigit(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!isAscii(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAscii(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    /**
     * 是否包含该字符串(不区分大小写)
     *
     * @param source   源字符串
     * @param matchStr 被包含的字符串
     * @return
     */
    public static boolean containsIgnoreCase(String source, String matchStr) {
        if (source == null || matchStr == null) {
            return false;
        } else if (source.contains(matchStr) || source.toLowerCase().contains(matchStr.toLowerCase())) {
            return true;
        }
        return false;
    }

    /**
     * 合并数组
     *
     * @param arrays
     * @return
     */
    public static String[] createArray(String[]... arrays) {
        int len = 0;
        for (int i = 0; i < arrays.length; i++) {
            len += arrays[i].length;
        }
        String[] newArray = new String[len];
        int totalLen = 0;
        for (int i = 0; i < arrays.length; i++) {
            String[] array = arrays[i];
            System.arraycopy(array, 0, newArray, totalLen, array.length);
            totalLen += array.length;
        }
        return newArray;
    }
}
