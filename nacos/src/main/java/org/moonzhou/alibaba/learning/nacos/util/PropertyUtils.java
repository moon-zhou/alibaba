/*
 * Copyright (C), 2002-2020, moon-zhou
 * FileName: PropertyUtils.java
 * Author:   moon-zhou
 * Email:    ayimin1989@163.com
 * Date:     2020/12/20 21:26
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名    修改时间    版本号       描述
 */
package org.moonzhou.alibaba.learning.nacos.util;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Properties;

/**
 * 功能描述: Properties处理类<br>
 *
 * @author moon-zhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PropertyUtils {

    /**
     * 将Properties实例对象转换成对应的bean对象
     * @param properties
     * @param clazz
     */
    public static void toObj(Properties properties, Class<?> clazz) {
        try {
            for(Map.Entry<Object, Object> property:properties.entrySet()){
                String key = (String) property.getKey();
                String value = (String) property.getValue();
                String attrName = propertyKey2JAttrName(key);

                if(hasProperty(clazz, attrName)) {
                    propertyFileAttr(clazz, attrName, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将'.'间隔的字符，首字母变为大写拼接起来，变成驼峰式名称
     *
     * e.g.
     *     listener.content -->  listenerContent
     * @param properyKey
     * @return
     */
    private static String propertyKey2JAttrName(String properyKey){

        if (StringUtils.isBlank(properyKey)) {
            return null;
        }

        StringBuffer attrName = new StringBuffer(50);
        String[] partNames = properyKey.split("\\.");

        for (int index = 0; index < partNames.length; index++) {
            String partName = partNames[index];

            if (index == 0 ) {
                attrName.append(partName);
                continue;
            }

            attrName.append(StringUtils.upperCase(StringUtils.substring(partName,0, 1)));
            attrName.append(StringUtils.substring(partName,1));
        }

        return attrName.toString();
    }

    /**
     * 判断对应的属性值是否存在
     * @param clazz
     * @param attrName
     * @return
     */
    private static boolean hasProperty(Class<?> clazz, String attrName) {
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals(attrName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据反射类将值设置到对应的属性里
     * @param clazz
     * @param attrName
     * @param value
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private static void propertyFileAttr(Class<?> clazz, String attrName, String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        Field filed = clazz.getDeclaredField(attrName);

        filed.setAccessible(true);

        /* 去除final修饰符的影响，将字段设为可修改的 */
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(filed, filed.getModifiers() & ~Modifier.FINAL);

        filed.set(filed.getName(), value);
    }
}
