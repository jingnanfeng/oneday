package com.nanfeng.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author liutao
 * @Title 转换流
 * @Description
 * InputStreamReader OutputStreamWriter
 * 编码：字符串 ---->字节数组
 * 解码：字节数组----->字符串
 * @date 2019-07-29 21:02
 */
public class TestTransformation {

    @Test
    public void test(){
        //解码过程
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            File file = new File("d:/test/hello1.txt");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"GBK");
            br = new BufferedReader(isr);
            String str;
            //编码
            File file1 = new File("d:/test/hello21.txt");
            FileOutputStream fos = new FileOutputStream(file1);
            OutputStreamWriter ows = new OutputStreamWriter(fos);
            bw = new BufferedWriter(ows);
            while ((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();
            }
            bw.flush();
        }catch (FileNotFoundException e){
            throw new RuntimeException("文件找不到");
        }catch (IOException e){
            throw new RuntimeException("IO操作异常");
        }finally {
            if (bw != null){
                try {
                    bw.close();
                }catch (IOException e){
                    throw new RuntimeException("IO关闭异常");
                }
            }
            if (br != null){
                try {
                    br.close();
                }catch (IOException e){
                    throw new RuntimeException("IO关闭异常");
                }
            }
        }
    }

    /**
     * 标准的输出流：System.out
     * 标准的出入流：System.in
     */
    @Test
    public void test2() {
        BufferedReader br = null;
        try {
            //从键盘上输入的
            InputStream in = System.in;
            InputStreamReader isr = new InputStreamReader(in);
            br = new BufferedReader(isr);
            String str;
            while (true){
                System.out.println("请输入字符串：");
                str = br.readLine();
                if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")){
                    break;
                }
                String str1 = str.toUpperCase();
                System.out.println(str1);
            }
        }catch (IOException e){
            throw new RuntimeException("IO流操作错误 ");
        }finally {
            if (br != null){
                try {
                    br.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
        }

    }

    /**
     * 使用字节流实现内容的输出
     */
    @Test
    public void test3(){
       BufferedOutputStream bos = null;
       try {
           bos = new BufferedOutputStream(new FileOutputStream(new File("d:/test/words.txt")));
           String str = "  is '基线id';\n" +
                   "comment on column AT_RE_BASELINE_FILE_HISTORY.file_path\n" +
                   "  is '项目组提供的差异文件地址';\n" +
                   "comment on column AT_RE_BASELINE_FILE_HISTORY.compared_file_path\n" +
                   "  is '系统对比出的差异文件地址';\n" +
                   "comment on column AT_RE_BASELINE_FILE_HISTORY.result_file_path\n" +
                   "  is 'UpdateList文件地址';\n" +
                   "comment on column AT_RE_BASELINE_FILE_HISTORY.create_time\n" +
                   "  is '创建时间';\n" +
                   "comment on column AT_RE_BASELINE_FILE_HISTORY.creator\n" +
                   "  is '创建者';\n" +
                   "comment on column AT_RE_BASELINE_FILE_HISTORY.modify_time\n" +
                   "  is '修改时间';\n" +
                   "comment on column AT_RE_BASELINE_FILE_HISTORY.modifier\n" +
                   "  is '修改者';\n" +
                   "comment on column AT_RE_BASELINE_FILE_HISTORY.del_flag\n" +
                   "  is '删除标识';\n" +
                   "-- Create/Recreate primary, unique and foreign key constraints \n" +
                   "alter table AT_RE_BASELINE_FILE_HISTORY\n" +
                   "  add constraint PK_BASELINE_FILE primary key (ID)\n" +
                   "  using index \n" +
                   "  tablespace USERS\n" +
                   "  pctfree 10";
           bos.write(str.getBytes());
           bos.flush();
       }catch (IOException e){
           throw new RuntimeException("IO操作错误");
       }finally {
           if (bos != null){
               try {
                   bos.close();
               }catch (IOException e){
                   throw new RuntimeException("IO流关闭异常");
               }
           }
       }
    }

    /**
     * 使用字符流实现文件的输出
     */
    @Test
    public void test4(){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("d:/test/hhh.txt"));
            String str = "  is '基线id';\n" +
                    "comment on column AT_RE_BASELINE_FILE_HISTORY.file_path\n" +
                    "  is '项目组提供的差异文件地址';\n" +
                    "comment on column AT_RE_BASELINE_FILE_HISTORY.compared_file_path\n" +
                    "  is '系统对比出的差异文件地址';\n" +
                    "comment on column AT_RE_BASELINE_FILE_HISTORY.result_file_path\n" +
                    "  is 'UpdateList文件地址';\n" +
                    "comment on column AT_RE_BASELINE_FILE_HISTORY.create_time\n" +
                    "  is '创建时间';\n" +
                    "comment on column AT_RE_BASELINE_FILE_HISTORY.creator\n" +
                    "  is '创建者';\n" +
                    "comment on column AT_RE_BASELINE_FILE_HISTORY.modify_time\n" +
                    "  is '修改时间';\n" +
                    "comment on column AT_RE_BASELINE_FILE_HISTORY.modifier\n" +
                    "  is '修改者';\n" +
                    "comment on column AT_RE_BASELINE_FILE_HISTORY.del_flag\n" +
                    "  is '删除标识';\n" +
                    "-- Create/Recreate primary, unique and foreign key constraints \n" +
                    "alter table AT_RE_BASELINE_FILE_HISTORY\n" +
                    "  add constraint PK_BASELINE_FILE primary key (ID)\n" +
                    "  using index \n" +
                    "  tablespace USERS\n" +
                    "  pctfree 10";
            bw.write(str);
            bw.flush();
        }catch (IOException e){
            throw new RuntimeException("IO操作异常");
        }finally {
            if (bw != null){
                try {
                    bw.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
        }
    }

    //使用字符流实现内容的读入
    @Test
    public void test6(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("d:/test/hhh.txt"));
            String str;
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }
        }catch (IOException e){
            throw new RuntimeException("IO操作异常");
        }finally {
            if (br != null){
                try {
                    br.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
        }
    }

    @Test
    public void copy(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("d:/test/hhh.txt"));
            bw = new BufferedWriter(new FileWriter("d:/test/aa.txt"));
            char[] c = new char[1024];
            int len;
            while ((len = br.read(c)) != -1){
                bw.write(c,0,len);
            }
            bw.flush();
        }catch (IOException e){
            throw new RuntimeException("IO流操作异常");
        }finally {
            if (bw != null){
                try {
                    bw.close();
                }catch (IOException e){
                    throw new RuntimeException("IO关闭异常");
                }
            }
            if (br != null){
                try {
                    br.close();
                }catch (IOException e){
                    throw new RuntimeException("IO关闭异常");
                }
            }
        }
    }


}
