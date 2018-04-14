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
public class WriteBack implements Runnable{
    
    SynchronousQueue<Integer> MEM_WB;
    
    public WriteBack(SynchronousQueue<Integer> MEM_WB){
        this.MEM_WB = MEM_WB;
    }

    @Override
    public void run() {
        
        System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- writeback start");
        try{
            int data = this.MEM_WB.take();
            System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- get date: " + data);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- writeback end");
    }
    
}
