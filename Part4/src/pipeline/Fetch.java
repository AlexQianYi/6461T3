/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeline;

import java.util.concurrent.SynchronousQueue;

/**
 *
 * @author yiqian
 */
public class Fetch implements Runnable{
    
    SynchronousQueue<Integer> IF_ID;
    
    public Fetch(SynchronousQueue<Integer> IF_ID){
        this.IF_ID = IF_ID;
    }

    @Override
    public void run() {
        
        System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- fetch start");
        try{
            int data = this.IF_ID.take();
            System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- get date: " + data);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- fetch end");
    }
    
}
