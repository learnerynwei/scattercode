package thread;

import java.util.concurrent.CyclicBarrier;

public class ThreadTest {

  class Thread1 extends Thread{
    CyclicBarrier barrier = new CyclicBarrier(10);
    public void run(){
      while( true ){
        System.out.println("Thread-------------1");
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  class Thread2 extends Thread{
    public void run(){
      while( true ){
        System.out.println("Thread-------------2");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public void test() throws InterruptedException{
    Thread1 th = new Thread1();

    Thread2 th2 = new Thread2();
    th.start();
    th2.start();
    th.join();
    th2.join();
  }

  public void test2() throws InterruptedException{
    Thread1 th = new Thread1();

    Thread2 th2 = new Thread2();
    th.start();
    th2.start();
  }

  public void test3() throws InterruptedException{
    Thread1 th = new Thread1();

    Thread2 th2 = new Thread2();
    th.run();
    th2.start();
  }
  public static void main(String[] args) throws InterruptedException {
    new ThreadTest().test3();
    System.out.println("Over");
  }
}
