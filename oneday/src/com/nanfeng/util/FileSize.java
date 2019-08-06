package com.nanfeng.util;

import java.text.DecimalFormat;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-05 12:01
 */

/**
 * 计算文件大小的工具类
 */
public class FileSize {

    public final static String fileSize(long size){
        int GB = 1024 * 1024 * 1024;
        int MB = 1024 * 1024;
        int KB = 1024;
        //格式转化小数
        DecimalFormat df = new DecimalFormat("0.00");
        String resultSize = "";
        //如果大于1GB
        if (size /GB >= 1){
            resultSize = df.format(size / (float)GB)+"GB";
        }else if (size / GB >= 1){
            resultSize = df.format(size / (float)MB) + "MB";
        }else if (size / KB >= 1){
            resultSize = df.format(size / (float)KB) + "KB";
        }else {
            resultSize = size + "B";
        }
        return resultSize;
    }

    public static void main(String[] args) {
        String str = fileSize(8077);
        System.out.println(str);
    }
}
