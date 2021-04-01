package she.why.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: v_junxxiao
 * @date: 2021/4/1
 */

class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * 加同步锁synchronized实现线程安全
     */
//    public synchronized void deposit(double amt) {//加同步锁synchronized实现线程安全
//        if (amt > 0) {
//            balance += amt;
//            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为："+balance);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    /**
     * 同步代码块synchronized实现线程安全
     */
//    public void deposit(double amt) {
//        synchronized (this) {
//            if (amt > 0) {
//                balance += amt;
//                System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    /**
     * lock锁实现线程安全
     */
    private ReentrantLock lock = new ReentrantLock();//默认为false，true：先进先出

    public void deposit(double amt) {
        lock.lock();
        try {
            if (amt > 0) {
                balance += amt;
                System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

class Person extends Thread{

    private Account account;

    public Person (Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}

public class ThreadSafeTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Person person1 = new Person(account);
        Person person2 = new Person(account);

        person1.setName("甲");
        person2.setName("乙");

        person1.start();
        person2.start();
    }
}
