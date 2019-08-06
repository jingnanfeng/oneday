package cn.com.nanfeng.pattern.proxy_pattern;

/**
 * @author liutao
 * @Title 代理模式
 * @Description
 * @date 2019-04-15 15:19
 */

abstract class Subject{

    public abstract void request();

}

class RealSubject extends Subject{
    @Override
    public void request() {
        System.out.println("真正的请求");
    }
}

class ProxySubject extends Subject implements Runnable{

    private RealSubject realSubject;

    @Override
    public void request() {

        if (realSubject == null){
            realSubject = new RealSubject();
            System.out.println("----------------------------------------");
        }
        realSubject.request();

    }

    @Override
    public void run() {
        synchronized (this){
            try {
                Thread.sleep(200);
                request();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class ProxySubjectApplication {

    public static void main(String[] args) {

        ProxySubject subject = new ProxySubject();
        for (int i = 0;i < 100;i++){
            Thread thread = new Thread(subject);
            thread.start();
        }
    }
}
