package com.nanfeng.one.extrnds;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-27 15:24
 */
public class Student {

    private int age;

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Test{
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : studentList) {
            int age = student.getAge();

        }
    }
}