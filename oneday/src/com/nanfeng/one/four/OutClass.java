package com.nanfeng.one.four;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-12 9:04
 */
public class OutClass {

    public void classout(boolean b){
        if (b){
            class InClass{
                public void inclass(){
                    System.out.println("这个一个内部类的方法");
                }
            }

            InClass inClass = new InClass();
            inClass.inclass();
        }
    }

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.classout(true);
    }
}
