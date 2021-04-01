package she.why.test;

/**
 * 实现Runnable创建线程
 *
 * @author: v_junxxiao
 * @date: 2021/3/24
 */

class MyThread3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadRunnableTest {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        Thread t1 = new Thread(myThread3);
        Thread t2 = new Thread(myThread3);
        t1.start();
        t2.start();


    }
}
/**
 *比较两者创建线程的方式：
 * 优先选择实现Runnable接口的方式
 * 原因：1，实现的方式没有类的单继承的局限性
 *      2，实现的方式更适合来处理多个线程有共享数据的情况
 *
 * 联系：
 *
 *
 */