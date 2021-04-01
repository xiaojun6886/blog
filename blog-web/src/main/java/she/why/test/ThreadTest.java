package she.why.test;

/**
 * 创建多线程
 * @author: v_junxxiao
 * @date: 2021/3/24
 */

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i=0; i<=100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        //thread-0线程
        t1.start();
        
        //thread-1线程
        MyThread t2 = new MyThread();
        t2.start();

        //main线程
        for (int i=0; i<=100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
