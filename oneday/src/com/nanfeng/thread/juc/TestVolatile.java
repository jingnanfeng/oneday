package com.nanfeng.thread.juc;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-02 20:42
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo th = new ThreadDemo();
        new Thread(th).start();

        while (true){
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.getMessage();
            }
            if (th.getFlag()){
                System.out.println("------------------");
                break;
            }
        }
    }





}

class ThreadDemo implements Runnable{

    private  boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        }catch (Exception e){
            e.getMessage();
        }
        flag = true;
        System.out.println("flag="+getFlag());
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
