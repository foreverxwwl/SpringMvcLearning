package com.utils;

import org.springframework.core.convert.converter.Converter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @outhor li
 * @create 2020-02-10 9:08
 * 把字符串转日期
 */
public class StringToDataConverter implements Converter<String, Date> {
    /**
     * String source  传入的字符串
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        if (source == null||source.length()==0){
            throw new RuntimeException("请传入信息");
        }
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return dataFormat.parse(source);
        }catch (Exception e){
            throw new RuntimeException("数据类型转换出现错误");
        }
    }


}
