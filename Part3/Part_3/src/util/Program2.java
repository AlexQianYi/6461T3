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
public class Program2 {
    public static final HashMap<String, Integer> PRE = new HashMap<>();
    static{
            PRE.put("31", 0);       //store the length of sentence
            PRE.put("30", 0);       //store the length of word
            PRE.put("29", 1);       //current sentence
            PRE.put("28", 1);       //current index of word in sentence
            PRE.put("27", 32);      //ascii of space
            PRE.put("26", 0);       //ascii of 0
            PRE.put("25", 46);      //ascii of '.'
            PRE.put("24", 0);       //R0 register
            PRE.put("23", 0);       
            PRE.put("22", -1);      //i
            PRE.put("21", 0);       //j
            PRE.put("20", 99);      //address 100, start position of sentences
            PRE.put("19", 79);      //address 80, start position of word
            PRE.put("18", 1601);    //start position of PROGRAM2_1
            PRE.put("17", 1701);    //start position of PROGRAM2_2
            PRE.put("16", 80);      //clean address 80
            PRE.put("15", 904);     //the first JMA address
            PRE.put("14", 989);     //end of program
            PRE.put("13", 951);     //the second JMA address
            PRE.put("12", 961);     //the third JMA address
            PRE.put("11", 937);     //the forth JMA address
            PRE.put("10", 969);     //the fifth JMA address
            PRE.put("9", 979);      //the sixth JMA address
            PRE.put("8", 902);      //the third JMA address
            PRE.put("7", 80);      
    }
}
