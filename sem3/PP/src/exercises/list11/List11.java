package exercises.list11;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class List11 {

    public static void Task2(){
        System.out.println("Task2");
        Account account = new Account();
        Thread thread1 = new Thread(() -> account.increase());
        Thread thread2 = new Thread(() -> account.decrease());
        thread1.start();
        thread2.start();
    }

    public static void Task3(){
        System.out.println("Task3");
        AccountSync accountSync = new AccountSync();
        Thread thread1 = new Thread(() -> accountSync.increase());
        Thread thread2 = new Thread(() -> accountSync.decrease());
        thread1.start();
        thread2.start();
    }

    public static void Task4(){
        final Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            if (i == philosophers.length - 1) {

                // The last philosopher picks up the right fork first
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            Thread t
                    = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }

    public static void Task5(){
        Runnable printInt = new Runnable() {
            private int counter = 0;
            @Override
            public void run() {
                System.out.println(counter);
                counter++;
                if(counter > 30)
                    System.exit(0);
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(printInt, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        Task2();
        TimeUnit.SECONDS.sleep(1);
        System.out.println();
        Task3();
        TimeUnit.SECONDS.sleep(1);
        System.out.println();

        //Task4();

        //Task5();
    }
}
