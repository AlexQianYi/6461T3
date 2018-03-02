/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author yiqian
 */
public class Const {
    
    /**
     *    Const in system
     */
    public static final Integer CACHE_LINES = 16;
    public static final Integer PG1_BASE_1 = 300;
    public static final Integer PG1_END_1 = 370;
    public static final Integer PG1_BASE_2 = 500;
    public static final Integer PG1_END_2 = 370;
    public static final Integer PG1_BASE_3 = 1800;
    public static final Integer PG1_END_3= 1862;
    
    public static final Integer Memory_Bound = 2048;
    public static final Integer Memory_Expand_Bound = 4096;
    
    public enum Fault {
	ILL_MEM_RSV(0, "Illegal Memory Address to Reserved Locations"), ILL_TRPC(1, "Illegal TRAP code"), ILL_OPRC(2,
	"Illegal Operation Code"), ILL_MEM_BYD(3, "Illegal Memory Address beyond 2048 (memory installed)");
	int value;
	String messsage;

	private Fault(int value, String message) {
		this.value = value;
		this.messsage = message;
	}

	public int getValue() {
            return this.value;
	}

	public String getMessage() {
            return this.messsage;
	}
    }
    
    public enum ConditionCode {
	OVERFLOW(0), UNDERFLOW(1), DIVZERO(2), EQUALORNOT(3);
	int value;

	private ConditionCode(int value) {
            this.value = value;
	}

	public int getValue() {
            return this.value;
	}
    }
    
    public enum DevId {
	KEYBOARD(0), PRINTER(1), CARD(2);
	int value;

	private DevId(int value) {
	this.value = value;
	}

	public int getValue() {
            return this.value;
	}	
    }
}
