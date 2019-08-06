package com.nanfeng.emnu;

import java.util.Arrays;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-23 20:56
 */
public class TestSeason1 {
    public static void main(String[] args) {
        Season1[] values = Season1.values();
        System.out.println(Arrays.toString(values));
        String str = "SPRING";
        System.out.println(Season1.valueOf(str));
        Season1 spring = Season1.SPRING;
        spring.show();
    }

}
interface info{
    void show();
}
/**
 * 枚举类
 * 1.如何自定义枚举类
 * 2.如何使用eumn关键字之定义枚举类
 */
enum Season1 implements info{
    //1把枚举对象放到最上面
    SPRING("spring","春暖花开"){
        public void show(){
            System.out.println("春天在哪里");
        }
    },
    SUMMER("summer","夏日炎炎") {
        @Override
        public void show() {
            System.out.println("生如夏花");
        }
    },
    AUTUMN("autumn","秋高气爽") {
        @Override
        public void show() {
            System.out.println("春天是用来分手的季节");
        }
    },
    WINTER("winter","白雪皑皑") {
        @Override
        public void show() {
            System.out.println("冬天里的一把火");
        }
    };

    //
    private final String seasonName;
    private final String seasonDesc;

    Season1(String seasonName, String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

   /* @Override
    public void show() {
        System.out.println("这是一个季节");
    }*/
}
