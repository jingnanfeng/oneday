package com.nanfeng.one.two;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-09 21:13
 */


/**
 * Userful类
 */
class Userful{
    public void a(){
        System.out.println("a()");
    }
    public void b(){
        System.out.println("b()");
    }
}

/**
 * 子类MoreUserful
 */
class MoreUserful extends Userful {

    @Override
    public void a() {
        System.out.println("More.a()");
    }

    @Override
    public void b() {
        System.out.println("More.b()");
    }

    public void c(){
        System.out.println("More.c()");
    }
    public void d(){
        System.out.println("More.d()");
    }
}

public class RTTI {

    public static void main(String[] args) {
        Userful userful = new MoreUserful();
        userful.a();
        userful.b();
        ((MoreUserful) userful).c();
        ((MoreUserful) userful).d();
    }
}
