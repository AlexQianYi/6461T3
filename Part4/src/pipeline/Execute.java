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
public class Execute implements Runnable{
    
    SynchronousQueue<Integer> ID_EX;
    SynchronousQueue<Integer> EX_MEM;
    
    public Execute(SynchronousQueue<Integer> ID_EX, SynchronousQueue<Integer> EX_MEM){
        this.ID_EX = ID_EX;
        this.EX_MEM = EX_MEM;
    }

    @Override
    public void run() {
        
        System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- execute start");
        try{
            int data = this.ID_EX.take();
            System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- get date: " + data);
            this.EX_MEM.put(data - 4);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- execute end");
    }
    
}
