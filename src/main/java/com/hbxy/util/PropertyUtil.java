/**
 * All rights Reserved, Copyright (C) FUJITSU LIMITED 2013
 * FileName: PropertyUtil.java
 * Version:  $Revision$
 * Modify record:
 * NO. |		Date		|		Name		|		Content
 * 1   |	2013-12-26		|	JFTT)FuXiaofeng	|	original version
 */
package com.hbxy.util;

import java.io.IOException;
import java.util.Properties;

/**
 * class name:PropertyUtil <BR>
 * class description: 读取配置文件工具类 <BR>
 * Remark: <BR>
 * @version 1.00 2013-12-26
 * @author JFTT)FuXiaofeng
 */
public class PropertyUtil {
	
	/** 读取src下configure.properties配置文件内容 */
	private final static String CONFIGURE_LOCATION = "configure.properties";
	/** 接收Properties内容 */
	private final static Properties property = new Properties();
	
	/**
	 * Method name: getConfigureProperties <BR>
	 * Description: 读取src下第三方配置文件thirdConfig.properties配置文件内容 <BR>
	 * Remark: <BR>
	 * @param propertyName
	 * @return String<BR>
	 */
	public static String getConfigureProperties(String propertyName) {
		try {
			property.load(PropertyUtil.class.getClassLoader().getResourceAsStream(CONFIGURE_LOCATION));
			String result = property.getProperty(propertyName);
			if (null != result && !"".equalsIgnoreCase(result)) {
				return result.trim();
			} else {				
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

}
