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
public class Decode implements Runnable{
    
    SynchronousQueue<Integer> IF_ID;
    SynchronousQueue<Integer> ID_EX;
    
    public Decode(SynchronousQueue<Integer> IF_ID, SynchronousQueue<Integer> ID_EX){
        this.IF_ID = IF_ID;
        this.ID_EX = ID_EX;
    }

    @Override
    public void run() {
        
        System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- decode start");
        try{
            int data = this.IF_ID.take();
            System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- get date: " + data);
            this.ID_EX.put(data - 4);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- decode end");
    }
    
}
