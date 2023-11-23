package method;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        //测试相关的方法
        T t = new T();
        t.setName("老韩");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start(); //启动子线程

        //主线程打印5个 hi,然后我就中断 子线程的休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        t.interrupt(); //当执行到这里，就会中断 t 线程的休眠
    }
}

class T extends Thread { //自定义的线程类
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                // Thread.currentThread().getName() 获取当前线程的名称
                System.out.println(Thread.currentThread().getName() + " 吃包子..." + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中...");
                Thread.sleep(20000); //20秒
            } catch (InterruptedException e) {
                // 当该线程执行到一个 interrupt 方法时，就会 catch 一个异常，可以加入自己的业务代码
                // InterruptedException 是捕获到一个中断异常.
                System.out.println(Thread.currentThread().getName() + " 被interrupt了");
            }
        }
    }
}
