package com.nanfeng.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-01 20:22
 */



public class ObjectPutStream {

    @Test
    public void test1(){
        Person p1 = new Person("小红",22);
        Person p2 = new Person("小米 ",33);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("d:/test/persion.txt"));
            oos.writeObject(p1);
            oos.flush();
            oos.writeObject(p2);
            oos.flush();
        }catch (IOException e){
            throw new RuntimeException("IO流操作异常");
        }finally {
            if (oos != null){
                try {
                    oos.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
        }
    }

    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("d:/test/persion.txt"));
            Person p1 = (Person)ois.readObject();
            System.out.println(p1);
            Person p2 = (Person)ois.readObject();
            System.out.println(p2);
        }catch (Exception e){
            throw new RuntimeException("IO操作异常");
        }finally {
            if (ois != null){
                try {
                    ois.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
        }
    }

}
class Person implements Serializable {
    private static final long serialVersionUID = -5092876051600562757L;
    static String name;
    transient Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}