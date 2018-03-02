/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import memory.Memory;

/**
 *
 * @author yiqian
 */
public class CPU {
    /**
    When we fetch the value from memory, the data type which need to store values
    from memory are set to string type, the data type which related with memory
    location or address are set to int.
    The int implies its value is decimal number, the string implies binary number
     */
    private int PC = 0;     //program counter
    private int cc=0; //condition code
    private String IR = ""; //Instruction Register, store string format of the binary number
    private int MAR = 0;    //Memory Address Register
    private String MBR = "";//Memory Buffer Register
    private String MSR = "0";//Machine Status Register
    private int MFR = 0;    //Machine Fault Register, contains Fault ID
    private int IAR = 0;    //Internal Address Register
    private String IRR = "0";//Internal Result Register
    private int FR0=0;
    private int FR1=0;
    Memory mainMemoryStore;

    public int opcode, registerSelect, IX, I, address;
    public int clock;
    //create 4 general registers
    int[] R = new int[4];

    //create 3 index registers
    int[] X = new int[3];

    
    //inital the value of reg
    
    public void setPC(int PCin){
        PC = PCin;
    }
    
    public void setMAR(int MARin){
        this.MAR = MARin;
    }
    
    public void setMBR(String MBRin){
        this.MBR = MBRin;
    }
    
    public void setMBR(int MBRin){
        this.MBR = String.valueOf(MBRin);
    }
    
    public void setMFR(int MFRin){
        this.MFR = MFRin;
    }
    
    public void setIR(String IRin){
        this.IR = IRin;
    }
    
    public int getPC(){
        return this.PC;
    }

    public int getMAR(){
        return this.MAR;
    }    
    
    public String getMBR(){
        return (MBR);
    }
    
    public int getIntMBR(){
        return Integer.parseInt(MBR);
    }
    
    public String getIR(){
        return this.IR;
    }
    
    public int getMFR(){
        return this.MFR;
    }
    
    public int getFRByNum(int num){
        if(num==0){
            return this.FR0;
        }
        if(num==1){
            return this.FR1;
        }
    }
    
    public void setFRByNum(int num, int value){
        if(num==0){
            this.FR0=value;
        }
        if(num==1){
            this.FR1=value;
        }
    }
    
    public void setCCElementByBit(int bitNum, boolean flag) {
        if (flag) {
            this.cc = (this.cc | (1 << bitNum));
        } else {
            int mask = ~(1 << bitNum);
            this.cc = this.cc & mask;
        }
    }
    
    public boolean getCCElementByBit(int bitNum) {
        return ((this.cc & (1 << bitNum)) != 0);
    }
    
    public int getCC(){
        return this.cc;
    }
    
    public void setRnByNum(int num, int value){
        if (num == 0)
            this.R[0]=value;
        if (num == 1)
            this.R[1]=value;
        if (num == 2)
            this.R[2]=value;
        if (num == 3)
            this.R[3]=value;
    }
    
    public int getRnByNum(int num){
        if (num == 0)
            return this.R[0];
        if (num == 1)
            return this.R[1];
        if (num == 2)
            return this.R[2];
        if (num == 3)
            return this.X[3];
        return 0;    
    }
    
    public int getXnByNum(int num) {
        if (num == 1)
            return this.X[0];
        if (num == 2)
            return this.X[1];
        if (num == 3)
            return this.X[2];
        return 0;
    }
    
    public void setXnByNum(int num, int value){
        if (num == 1)
            this.X[0]=value;
        if (num == 2)
            this.X[1]=value;
        if (num == 3)
            this.X[2]=value;       
    }
    
    public void increasePC(){
        this.PC++;
    }
}