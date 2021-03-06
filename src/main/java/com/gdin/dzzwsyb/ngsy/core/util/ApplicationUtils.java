package com.gdin.dzzwsyb.ngsy.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * ApplicationUtils : 程序工具类，提供大量的便捷方法
 *
 */
public class ApplicationUtils {

	/**
	 * 产生一个36个字符的UUID
	 *
	 * @return UUID
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * md5加密
	 *
	 * @param value
	 *            要加密的值
	 * @return md5加密后的值
	 */
	public static String md5Hex(String value) {
		return DigestUtils.md5Hex(value);
	}

	/**
	 * sha1加密
	 *
	 * @param value
	 *            要加密的值
	 * @return sha1加密后的值
	 */
	public static String sha1Hex(String value) {
		return DigestUtils.sha1Hex(value);
	}

	/**
	 * sha256加密
	 *
	 * @param value
	 *            要加密的值
	 * @return sha256加密后的值
	 */
	public static String sha256Hex(String value) {
		return DigestUtils.sha256Hex(value);
	}

	/**
	 * 督办事项、提请事项、附件表主键获取
	 * 
	 * @return 获取一个随机主键
	 */
	public static String newUUID() {
		return sha1Hex(randomUUID().toString());
	}

	/**
	 * 替换目标String为空字符串
	 * @param string
	 * @return
	 */
	public static String replaceNullToEmpty(String string) {
		return (string == null ? "" : string);
	}

	/**
	 * 替换目标String为&emsp
	 * @param string
	 * @return
	 */
	public static String replaceNullToEmsp(String string) {
		return (string == null ? "&emsp;" : ("".equals(string) ? "&emsp;" : string));
	}
	/**
	 * 获取系统当前时间
	 * @param string
	 * @return
	 * @throws ParseException 
	 */
	public static Date getTime() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return sdf.parse(sdf.format(new Date()));
	}
	/**
	 * 获取系统当前时间
	 * @param string
	 * @return
	 * @throws ParseException 
	 */
	public static Date getYMD() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		return sdf.parse(sdf.format(new Date()));
	}
	public static String removeTag(String string) {
		return string.replaceAll("<[^>]+>", "").replaceAll("&nbsp;", "").replaceAll("&emsp;", "").replaceAll("&ensp;", "");
	}
	
	/**
	 * 计算年龄
	 * 
	 */
	public static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
           return 0;
        }
    }
}
