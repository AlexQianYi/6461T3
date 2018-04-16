/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.HashMap;

/**
 *
 * @author yiqian
 */
public class ProgramFloatAdd {
    
    public static final HashMap<String, Integer> Pre_FloatAdd = new HashMap<>();
    static{
        Pre_FloatAdd.put("6", 32);    // ascii of ' '
        Pre_FloatAdd.put("7", 46);    //ascii of '.'
        Pre_FloatAdd.put("6", 43);   // 43 ascii of '+'
        Pre_FloatAdd.put("7", 45);   // 45 ascii of '-'
        Pre_FloatAdd.put("8", 32);   // 32 ascii of ' '
        Pre_FloatAdd.put("28", 302); // read 20 number loop start address
        Pre_FloatAdd.put("29", 7);   // the lowest address of 20 numbers
        Pre_FloatAdd.put("30", 2);  // the number of number need to read in Program 1
        Pre_FloatAdd.put("31", 505); // address need in compare program
    }    
    
    public static final HashMap<String, Integer> Read_FloatAdd = new HashMap<>();
    static{

        
        Read_FloatAdd.put("300", Integer.MIN_VALUE);   //LDFR Fr0<-c(28)
        Read_FloatAdd.put("302", Integer.MIN_VALUE);   //FADD Fr0<Fr0+c(29)
        Read_FloatAdd.put("303", Integer.MIN_VALUE);   //STFR c(30)<-Fr0
        Read_FloatAdd.put("304", Integer.MIN_VALUE);   //OUT  Fr0
        
        
    }    
    
}
