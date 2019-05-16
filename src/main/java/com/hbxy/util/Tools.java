package com.hbxy.util;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools
{

	private static Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");

	/**
	 * 正常的行数
	 */
	static long normalLine = 0;

	/**
	 * 注释行数
	 */
	static long comentLine = 0;

	/**
	 * 空行数
	 */
	static long whiteLine = 0;

	/**
	 * 总行数
	 */
	static long countLine = 0;

	/**
	 * 随机生成六位数验证码
	 * @return
	 */
	public static int getRandomNum() {
		Random r = new Random();
		// (Math.random()*(999999-100000)+100000)
		return r.nextInt(900000) + 100000;
	}

	/**
	 * 检测字符串是否不为空(null,"","null")
	 * @param s
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean notEmpty(String s) {
		return s != null && !"".equals(s) && !"null".equals(s);
	}

	/**
	 * 检测字符串是否为空(null,"","null")
	 * @param s
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(String s) {
		return s == null || "".equals(s) || "null".equals(s);
	}

	/**
	 * 字符串转换为字符串数组
	 * @param str 字符串
	 * @param splitRegex 分隔符
	 * @return
	 */
	public static String[] str2StrArray(String str, String splitRegex) {
		if (isEmpty(str)) {
			return null;
		}
		return str.split(splitRegex);
	}

	/**
	 * 用默认的分隔符(,)将字符串转换为字符串数组
	 * @param str 字符串
	 * @return
	 */
	public static String[] str2StrArray(String str) {
		return str2StrArray(str, ",\\s*");
	}

	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String date2Str(Date date) {
		return date2Str(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date) {
		if (notEmpty(date)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Date();
		} else {
			return null;
		}
	}

	/**
	 * 按照参数format的格式，日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date, String format) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} else {
			return "";
		}
	}

	/**
	 * 把时间根据时、分、秒转换为时间段
	 * @param strDate
	 */
	public static String getTimes(String strDate) {
		String resultTimes = "";

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now;

		try {
			now = new Date();
			Date date = df.parse(strDate);
			long times = now.getTime() - date.getTime();
			long day = times / (24 * 60 * 60 * 1000);
			long hour = (times / (60 * 60 * 1000) - day * 24);
			long min = ((times / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long sec = (times / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

			StringBuffer sb = new StringBuffer();
			if (hour > 0) {
				sb.append(hour + "小时前");
			} else if (min > 0) {
				sb.append(min + "分钟前");
			} else {
				sb.append(sec + "秒前");
			}

			resultTimes = sb.toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return resultTimes;
	}

	/**
	 * 写txt里的单行内容
	 * @param fileP 文件路径
	 * @param content 写入的内容
	 */
	public static void writeFile(String fileP, String content) {
		String keyPre = ":";
		// 项目路径
		String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource("")) + "../../";
		filePath = (filePath.trim() + fileP.trim()).substring(6).trim();
		if (filePath.indexOf(keyPre) != 1) {
			filePath = File.separator + filePath;
		}
		try {
			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
			BufferedWriter writer = new BufferedWriter(write);
			writer.write(content);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 验证邮箱
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(email);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 验证手机号码
	 * @param mobileNumber
	 * @return
	 */
	public static boolean checkMobileNumber(String mobileNumber) {
		boolean flag = false;
		try {
			Matcher matcher = regex.matcher(mobileNumber);
			flag = matcher.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 读取txt里的单行内容
	 * @param fileP 文件路径
	 */
	public static String readTxtFile(String fileP) {
		try {
			String keyPre = ":";
			// 项目路径
			String filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""));
			filePath = filePath.replaceAll("file:/", "");
			filePath = filePath.replaceAll("%20", " ");
			filePath = filePath.trim() + fileP.trim();
			if (filePath.indexOf(keyPre) != 1) {
				filePath = File.separator + filePath;
			}
			String encoding = "utf-8";
			File file = new File(filePath);
			// 判断文件是否存在
			if (file.isFile() && file.exists()) {
				// 考虑到编码格式
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					return lineTxt;
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件,查看此路径是否正确:" + filePath);
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
		}
		return "";
	}

	public static void main(String[] args) {
		//代码文件路径
		File file = new File("E:\\project\\apartment");
		//得到当前路径下的子目录
		File [] files = file.listFiles();
		//遍历
		tree(file);
		countLine = normalLine +comentLine + whiteLine;
		System.out.println("正常代码:"+normalLine);
		System.out.println("注释代码:"+comentLine);
		System.out.println("空行数:"+whiteLine);
		System.out.println("总行数:"+countLine);
	}

	private static void count(File child) {

		FileReader fileReader = null;
		BufferedReader br = null;
		boolean coments = false;
		try {
			fileReader = new FileReader(child);
			br = new BufferedReader(fileReader);
			String line = "";
			while((line=br.readLine())!=null) {
				/*
				 *  去掉开头和末尾的空格行  防止出现
				 *	 注释开始前存在空格而导致没有计入注释行的问题
				 *	 注释结尾前存在空格而导致不匹配的问题
				 */
				line = line.trim();
				if(line.matches("^[\\s&&[^\\n]]*$")) {
					whiteLine++;
				} else if(line.startsWith("/*")&&!line.endsWith("*/")) {
					comentLine++;
					coments = true;
				} else if(true == coments ) {
					comentLine++;
					if(line.endsWith("*/")){
						coments = false;
					}
				}// 一行以/*开头。以*/结尾
				else if(line.startsWith("/*")&&line.endsWith("*/")) {
					comentLine++;
				}
				else if(line.startsWith("//")) {
					comentLine++;
				}
				else{
					normalLine++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 递归遍历所有java文件
	 */
	public static void tree(File file) {
		File[] childFiles = file.listFiles();
		for(File child : childFiles) {
			if(child.getName().matches(".*\\.java$")) {
				count(child);
			}
			if(child.isDirectory()) {
				tree(child);
			}
		}
	}
}
