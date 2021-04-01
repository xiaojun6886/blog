package she.why.test;

/**
 * 继承Thread类创建线程
 * @author: v_junxxiao
 * @date: 2021/3/24
 */

public class ThreadDemo {
    public static void main(String[] args) {
        //通过写两个子类创建两个不同的线程
        MyThread1 myThread1 = new MyThread1("线程一");
        MyThread2 myThread2 = new MyThread2("线程二");
        myThread1.start();
        myThread2.start();

        //创建Thread类的匿名子类的方式
        new Thread("线程一") {
            @Override
            public void run() {
                for (int i=0; i<=100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();

        new Thread("线程二") {
            @Override
            public void run() {
                for (int i=0; i<=100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i=0; i<=100; i++) {
            if (i % 2 == 0) {
                try {
                    //进入睡眠状态
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

            //释放当前cpu的执行权
            if (i % 20 == 0) {
                yield();
            }
        }
    }
    public MyThread1 (String name) {
        super(name);
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i=0; i<=100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }

            //当满足条件时，当前线程阻塞，会先去执行完其他线程再执行此线程
            if (i == 20) {
                try {
                    join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public MyThread2 (String name) {
        super(name);
    }
}
