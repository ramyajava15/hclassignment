package com.sphinix.challenge1;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class PrimeCheckerQueue implements Runnable{
	
private BlockingQueue<Integer> queue;
private BlockingQueue<Integer> primeQueue;
    
    public PrimeCheckerQueue(BlockingQueue<Integer> q, BlockingQueue<Integer> primeq){
        this.queue = q;
        this.primeQueue = primeq;
    }
    @Override
    public void run() {
        try{
        	int randomInt;
            //consuming messages until exit message is received
            while((randomInt = queue.take()) != 0){
            Thread.sleep(1000);
            if(isPrime(randomInt)){
            	System.out.println("Recieved number "+ randomInt+" is a Prime number");
            	//primeQueue.put(randomInt);
            }else{
            	System.out.println("Recieved number "+ randomInt+" is Non-prime number");
            }
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    static boolean isPrime(int n) { 
	    if (n%2==0) return false; 
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

    
	}