package com.nanfeng.emnu;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-20 12:39
 */
public class TestSeason {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        System.out.println(season);
    }
}
//枚举类
class Season{
    //私有属性,声明为fianl 不可修改
    private final String seasonName;
    private final String seasonDesc;


    //私有化构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
    //创建枚举类的对象 public static final
    public static final Season SPRING = new Season("spring","春暖花开");
    public static final Season SUMMER = new Season("summer","春暖花开");
    public static final Season SUTUMN = new Season("autumn","春暖花开");
    public static final Season WINTER = new Season("winter","春暖花开");
}
