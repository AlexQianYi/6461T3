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
    
    //read/store sentences
    public static final HashMap<String, Integer> PROGRAM2_1 = new HashMap<>();
    static{
            PROGRAM2_1.put("1600", 0xf34);      //LDA R3 m(20)
            
            //input 1 sentence==null?
            PROGRAM2_1.put("1601", 0xf502);     //IN R1<-input
            PROGRAM2_1.put("1602", 0xe32);      //LDA R2<-m(18)     R2=1601
            PROGRAM2_1.put("1603", 0x1a14);     //AIR R2<-R2+20     R2=1621
            PROGRAM2_1.put("1604", 0xa12);      //STR m(18)<-R2
            PROGRAM2_1.put("1605", 0x2932);     //JZ R1==0?PC<-m(18):PC++
            
            PROGRAM2_1.put("1606", 0xf901);     //OUT output<-R1
            PROGRAM2_1.put("1607", 0xc3f);      //LDA R0<-m(31)     R0=0
            PROGRAM2_1.put("1608", 0x1801);     //AIR R0<-R0+1      R0=1    1 word
            PROGRAM2_1.put("1609", 0x81f);      //STR m(31)<-R1     m(31)=1
            PROGRAM2_1.put("1610", 0xc34);      //LDA R0<-m(20)     R0=99
            PROGRAM2_1.put("1611", 0x1801);     //AIR R0<-R0+1      R0=100
            PROGRAM2_1.put("1612", 0x814);      //STR m(20)<-R0     m(20)=100
            PROGRAM2_1.put("1613", 0x934);      //STR m(100)<-R1    store input at address 100
            PROGRAM2_1.put("1614", 0xe32);      //LDA R2<-m(18)     R2=1621
            PROGRAM2_1.put("1615", 0x1e14);     //SIR R2<-R2-imm(20)R2=1601
            PROGRAM2_1.put("1616", 0xa12);      //STR m(18)<-R2     m(18)=1601
            PROGRAM2_1.put("1617", 0x3432);     //JMA m(18)         PC=1601
            
            //input 2 sentence==null?
            PROGRAM2_1.put("1621", 0x7d8f);     //SRC reset R1<-0
            PROGRAM2_1.put("1622", 0x190a);     //AIR R1<-R1+imm(10) R1=10
            PROGRAM2_1.put("1623", 0xf901);     //OUT output<-R1
            PROGRAM2_1.put("1624", 0xb14);      //STR m(20)<-R3
                       
    }
    
    //read/store 1 word need to be searched
    public static final HashMap<String, Integer> PROGRAM2_2 = new HashMap<>();
    static{
        PROGRAM2_2.put("1700", 0xf33);      //LDA R3<-m(19)     R3=79
        
        //read word
        PROGRAM2_2.put("1701", 0xf500);     //IN R1<-input
        PROGRAM2_2.put("1702", 0xe31);      //LDA R2<-m(17)     R2=1701
        PROGRAM2_2.put("1703", 0x1a14);     //AIR R2<-R2+imm(20)R2=1721
        PROGRAM2_2.put("1704", 0xa11);      //STR m(17)<-R2     m(17)=1721
        PROGRAM2_2.put("1705", 0x2931);     //JZ
        
        PROGRAM2_2.put("1706", 0xf901);     //OUT output<-R1
        PROGRAM2_2.put("1707", 0xc3e);      //LDA R0<-m(30)     R0=0    length of word
        PROGRAM2_2.put("1708", 0x1801);     //AIR R0<-R0+imm(1) R0=1
        PROGRAM2_2.put("1709", 0x81e);      //STR m(30)<-R0
        PROGRAM2_2.put("1710", 0xc33);      //LDA R0<-m(19)     R0=79
        PROGRAM2_2.put("1711", 0x1801);     //AIR R0<-R0+imm(1) R0=80
        PROGRAM2_2.put("1712", 0x813);      //STR m(19)<-R0
        PROGRAM2_2.put("1713", 0x933);      //STR m(m(19))<-R1  store word at 80
        PROGRAM2_2.put("1714", 0xe31);      //LDA R2<-m(17)     R2=1721
        PROGRAM2_2.put("1715", 0x1e14);     //SIR R2<-R2-imm(20)
        PROGRAM2_2.put("1716", 0xa11);      //STR m(17)<-R2
        PROGRAM2_2.put("1717", 0x3431);     //JMA PC<-1701
    }
    
    //search word in sentences
    public static final HashMap<String, Integer> PROGRAM2_3 = new HashMap<>();
    static{
           PROGRAM2_3.put("900", 0x61f);        //LDA R3<-m(31)     R3=0
           PROGRAM2_3.put("901", 0x1a01);       //AIR R3<-R3+imm(1) R3=1
           //PROGRAM2_3.put("902", 0x422f);       //SOB
           PROGRAM2_3.put("903", 0x342e);       //JMA PC<-m(14)     jump to end of program
           PROGRAM2_3.put("904", 0x416);        //LDA R0<-m(22)     R0=i
           PROGRAM2_3.put("905", 0x1801);       //AIR R0<-R0+imm(1)
           PROGRAM2_3.put("906", 0x816);        //STR m(22)<-R0
           PROGRAM2_3.put("907", 0x414);        //LDR R0<-m(m(20))  R3=99
           PROGRAM2_3.put("908", 0x1801);       //AIR R0<-R0+imm(1) R0=100
           PROGRAM2_3.put("909", 0x814);        //STR m(20)<-R0
           PROGRAM2_3.put("910", 0x534);        //LDR R1<-m(m(20))  load sentence from address 100
           PROGRAM2_3.put("911", 0x419);        //LDR R0<-m(m(25))  R0=46 load '.'
           PROGRAM2_3.put("912", 0x5840);       //TRR R1 R0         whether == '.'
           PROGRAM2_3.put("913", 0x332d);       //JCC if=='.' PC<-m(13) PC=951
           PROGRAM2_3.put("914", 0x41b);        //LDR R0<-m(m(27))  load ' '
           PROGRAM2_3.put("915", 0x5840);       //TRR R1 R0         whether == ' '
           PROGRAM2_3.put("916", 0x61f);        //LDA R3<-m(31)
            
    }
}
