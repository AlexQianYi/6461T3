/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeline;

import java.util.concurrent.SynchronousQueue;
import cpu.CPU;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import memory.MCU;

/**
 *
 * @author yiqian
 */
public class pipeline_control {
    
    private int PCstart;
    private int PCend;
    private CPU cpu;
    private MCU mcu;
    
    // pipeline task
    private Fetch IF;
    private Decode ID;
    private Execute EX;
    private Mem MEM;
    private WriteBack WB;
    
    // pipeline thread
    private Thread IF_thread;
    private Thread ID_thread;
    private Thread EX_thread;
    private Thread MEM_thread;
    private Thread WB_thread;
    
    private Queue<Integer> PC;
    private Queue<String> Instruction;
    private ArrayList<String> Order;
    private ArrayList<Integer> Memory2Visit;
    
    
    
    public pipeline_control(int PCstart, int PCend, CPU cpu, MCU mcu ){
        this.PC = new LinkedList<Integer>();
        this.Instruction = new LinkedList<String>();
        this.PCstart = PCstart;
        this.PCend = PCend;
        this.cpu = cpu;
        this.mcu = mcu;
        
        PC.offer(PCstart);
        
        run();
        
    }
    
    private void run(){
        
        IF_thread.start();
        ID_thread.start();
        EX_thread.start();
        MEM_thread.start();
        WB_thread.start();
        
        while(PC.size()!=0 || ID_EX_size!=0 && EX_MEM_size!=0 && MEM_WB_size!=0){
            
        }
        
    }
    

    
    // Fetch task
    private class Fetch implements Runnable{

        @Override
        public void run() {
        
            int PC_temp;
            System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- fetch start");
            try{
                if(VisitIF_ID(0)){
                    PC_temp = PC.remove();
                    cpu.setPC(PC_temp);
                    cpu.setMAR(cpu.getPC());
                    cpu.setMBR(mcu.fetchFromCache(cpu.getMAR()));
                    cpu.setIR(cpu.getIntMBR());
                    Instruction.add(cpu.getBinaryStringOfIR());
                }else{
                    Thread.sleep(200);
                }
                System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- fetch instruction: " + data);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Thread Id: " + Thread.currentThread().getId() + " --- fetch end");
        }
    
    }
 
    private synchronized boolean VisitIF_ID(int sign){
        if(sign==0){
            if(PC.size()==0){
                return false;
            } else{
                return true;
            }
        }else{
            return true;
        }
    }
        
    private synchronized boolean VisitID_EX(int sign){
        if(sign==0){
            if(Instruction.size()==0){
                return false;
            } else{
                return true;
            }
        }else{
            return true;
        }        
    }
    
}
