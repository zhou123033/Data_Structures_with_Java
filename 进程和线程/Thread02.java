public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
        T21 t2 = new T21();
        t2.start();

        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程 吃了" + i + " 包子");
            if (i == 5) {
                System.out.println("主线程 让 子线程 先吃");
                t2.join();// 这里相当于让 t2 线程先执行完毕
                System.out.println("线程 吃完了 主线程接着吃");
            }
        }
    }
}

class T21 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程 吃了" + i + "包子");
        }
    }
}
