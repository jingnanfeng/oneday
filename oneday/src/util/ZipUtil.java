package util;

import com.nanfeng.emnu.ErrorCode;
import com.nanfeng.exception.BusinessException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-24 10:37
 */
public class ZipUtil {

    private static final Integer BUFFER_ZISE = 1024;
    /**
     * @param srcFile zip源文件
     * @param destDirPath 解压后的目标文件夹
     * @throws RuntimeException
     */
    public static void unZip(File srcFile, String destDirPath) throws RuntimeException{
        long start = System.currentTimeMillis();
        //判断源文件是否存在
        if (!srcFile.exists()){
            throw new BusinessException(1001,"文件不存在");
        }
        //开始解压
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(srcFile, Charset.forName("gbk"));
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()){
                ZipEntry entry = (ZipEntry)entries.nextElement();
                System.out.println("解压 = {}"+entry.getName());
                //如果是个文件夹，就创建文件夹
                if (entry.isDirectory()){
                    String dirPath = destDirPath+"/"+entry.getName();
                    File dir = new File(dirPath);
                }else {
                    //如果是个文件，就创建这个文件，然后用io流把内容copy进去
                    File targetFile = new File(destDirPath + "/"+entry.getName());
                    //保证这个文件的父文件夹必须存在
                    if (!targetFile.getParentFile().exists()){
                        targetFile.getParentFile().mkdirs();
                    }
                    //将压缩文件内容写入到这个文件中
                    InputStream is = zipFile.getInputStream(entry);
                    FileOutputStream fos = new FileOutputStream(targetFile);
                    int len;
                    byte[] buf = new byte[BUFFER_ZISE];
                    while ((len = is.read(buf)) != -1){
                        fos.write(buf,0,len);
                    }
                    //关闭流
                    fos.close();
                    is.close();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("++++++++++++++++++++++耗时"+(end - start)+"++++++++++++++++++++++");
        }catch (IOException e){
            throw new BusinessException(ErrorCode.G1002.getCode(),ErrorCode.G1002.getMessage());
        }finally {
            try {
                if (zipFile != null){
                    zipFile.close();
                }
            }catch (IOException e){
                throw new BusinessException(ErrorCode.G1002.getCode(),ErrorCode.G1002.getMessage());
            }
        }
    }

    /**
     * 归遍历文件夹下的所有文件
     */
    public static List<String> getAllFiles(File dir) throws Exception{
        List<String> files = new ArrayList<>();
        //如果是目录
        if (dir.isDirectory()){
            //获取目录下所有的文件
            File[] docimentArr = dir.listFiles();
            if (docimentArr != null){
                //遍历目录下的所有的文件，执行递归
                for (File document : docimentArr) {
                    files.addAll(getAllFiles(document));
                }
            }
        }else {
            //如果是文件，加入到list中
            files.add(dir.getAbsolutePath());
        }
        return files;
    }

    public static void main(String[] args) {
        /*File file = new File("D:\\IO\\222.zip");
        unZip(file,"D:\\IO\\test");
        System.out.println();*/
        try {
            List<String> allFiles = getAllFiles(new File("D:\\IO\\test"));
            for (String allFile : allFiles) {
                System.out.println(allFile);
            }
        }catch (Exception e){
            throw new BusinessException(ErrorCode.G1007.getCode(),ErrorCode.G1007.getMessage());
        }

    }

}
