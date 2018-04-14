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
public class Mem implements Runnable{
    
    SynchronousQueue<Integer> EX_MEM;
    SynchronousQueue<Integer> MEM_WB;
    
    public Mem(SynchronousQueue<Integer> EX_MEM, SynchronousQueue<Integer> MEM_WB){
        this.EX_MEM = EX_MEM;
        this.MEM_WB = MEM_WB;
    }

    @Override
    public void run() {
        
        System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- memory start");
        try{
            int data = this.EX_MEM.take();
            System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- get date: " + data);
            this.MEM_WB.put(data - 4);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- memory end");
    }
    
}
