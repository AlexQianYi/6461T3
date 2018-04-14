/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeline;

import java.util.concurrent.SynchronousQueue;
import cpu.CPU;

/**
 *
 * @author yiqian
 */
public class pipeline_control {
    
    private int PCstart;
    private int PCend;
    private CPU cpu;
    
    // pipeline thread
    private Fetch IF;
    private Decode ID;
    private Execute EX;
    private Mem MEM;
    private WriteBack WB;
    
    SynchronousQueue<Integer> IF_ID = new SynchronousQueue<Integer>(true);
    SynchronousQueue<Integer> ID_EX = new SynchronousQueue<Integer>(true);
    SynchronousQueue<Integer> EX_MEM = new  SynchronousQueue<Integer>(true);
    SynchronousQueue<Integer> MEM_WB = new  SynchronousQueue<Integer>(true);
    
    
    public pipeline_control(int PCstart, int PCend, CPU cpu ){
        this.PCstart = PCstart;
        this.PCend = PCend;
        this.cpu = cpu;
        
        run();
        
    }
    
    private void run(){
        
    }
    
}
