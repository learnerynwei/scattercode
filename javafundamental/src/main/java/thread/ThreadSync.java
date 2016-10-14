package thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSync {
  public static void testCyclicBarrier() {
    final int[] array = new int[3];
    CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
      // 在所有线程都到达Barrier时执行
      public void run() {
        System.out.println("testCyclicBarrier run...");
        array[2] = array[0] + array[1];
      }
    });

    // 启动线程
    new Thread(new ComponentThread(barrier, array, 0)).start();
    new Thread(new ComponentThread(barrier, array, 1)).start();
  }

  public static void testCountSyn() throws InterruptedException{
    for( int i =0 ; i < 10; ++i){
      ComponentThread.setCount(0);
      for(int j=0; j < 5; ++j)
        ThreadSync.testCyclicBarrier();
      while( ComponentThread.getCount() < 10 )
        ;
        System.out.println("--------------Waiting for round "+ i + " finished!");
      System.out.println("-------------Finish Round " + i);
      //Thread.sleep(1000);
    }
  }
  public static void main(String[] args) throws InterruptedException {
    ThreadSync.testCountSyn();
  }
}

class ComponentThread implements Runnable {
  private static AtomicInteger count = new AtomicInteger(0);
  private
  CyclicBarrier barrier;// 计数器
  int           ID;     // 组件标识
  int[]         array;  // 数据数组

  public static int getCount() {
    return count.get();
  }

  public static void setCount(int val) {
    count.set(val);
  }

  public static void incur(){
    count.getAndIncrement();
  }
  // 构造方法
  public ComponentThread(CyclicBarrier barrier, int[] array, int ID) {
    this.barrier = barrier;
    this.ID = ID;
    this.array = array;
  }

  public void run() {
    try {
      array[ID] = new Random().nextInt(100);
      System.out.println("Component " + ID + " generates: " + array[ID]);
      // 在这里等待Barrier处
      System.out.println("Component " + ID + " sleep...");
      barrier.await();
      System.out.println("Component " + ID + " awaked...");
      // 计算数据数组中的当前值和后续值
      int result = array[ID] + array[ID + 1];
      System.out.println("Component " + ID + " result: " + result);
    } catch (Exception ex) {
    }
    count.getAndIncrement();
    System.out.println("-------------Count is: " + count.get());
  }
}
