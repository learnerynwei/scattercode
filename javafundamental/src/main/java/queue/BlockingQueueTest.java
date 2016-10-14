package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
  private int                         queueSize = 100;
  private LinkedBlockingQueue<Integer> queue     = new LinkedBlockingQueue<>(queueSize);
//  private ArrayList<Integer> queue     = new ArrayList<Integer>(queueSize);

  public static void main(String[] args) {
    BlockingQueueTest test = new BlockingQueueTest();
    Producer producer = test.new Producer();
    Consumer consumer = test.new Consumer();
    Consumer consumer2 = test.new Consumer();

    producer.start();
    consumer.start();
    consumer2.start();
  }

  class Producer extends Thread {
    @Override
    public void run() {
      produce();
    }

    private void produce() {
      int n = 3;
      while (n-- > 0) {
        for (int i = 0; i < 100; i++) {
          queue.offer(i);
        }
        // queue.put(1);
        // System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
      }
    }
  }

  class Consumer extends Thread {
    @Override
    public void run() {
      try {
        consume();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public void consume() throws InterruptedException {
    while (true) {
      Integer e = queue.take();
      // System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
      System.out.println(Thread.currentThread().getName() + "从队列取走一个元素，元素是:" + e);
    }
  }
}