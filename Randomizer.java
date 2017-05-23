package com.sphinix.challenge1;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Randomizer implements Runnable{

	private BlockingQueue<Integer> queue;
	private BlockingQueue<Integer> primeQueue;
    
    public Randomizer(BlockingQueue<Integer> q,BlockingQueue<Integer> primeq){
        this.queue=q;
        this.primeQueue = primeq;
    }

    @Override
    public void run() {
        //produce random numbers
    	Random randomGenerator = new Random();
        for(int i=0; i<100; i++){
        	int randomInt = randomGenerator.nextInt(100);
            try {
                queue.put(randomInt);
                System.out.println("Sending "+randomInt);
                Thread.sleep(1000);
                //System.out.println("Prime num received"+ primeQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
  public static void main( String[] args ) throws Exception {
	  BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	  BlockingQueue<Integer> primeQueue = new ArrayBlockingQueue<>(10);
	  Randomizer producer = new Randomizer(queue,primeQueue);
      PrimeCheckerQueue consumer = new PrimeCheckerQueue(queue,primeQueue);
      //starting producer to produce messages in queue
      new Thread(producer).start();
      //starting consumer to consume messages from queue
      new Thread(consumer).start();
      System.out.println("Randomizer and PrimeCheker threads has been started");
  }
}

