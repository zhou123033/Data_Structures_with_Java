package threaduse;

/**
 * 通过实现 Runnable 接口来开发线程
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start(); 这里不能调用start方法
        //创建了 Thread 对象, 把 dog 对象(实现Runnable) 放入Thread
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable {//通过实现 Runnable 接口，开发线程

    int count = 0;
    @Override
    public void run() { //普通方法
        while (true) {
            System.out.println("小狗汪汪叫..hi " + (++count) +
                    Thread.currentThread().getName());
            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
