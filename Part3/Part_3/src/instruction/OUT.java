/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instruction;

import cpu.CPU;
import memory.MCU;
import util.Const;
import util.EffectiveAddress;
import util.MachineFaultException;
import util.StringUtil;

/**
 *
 * @author yiqian
 */
public class OUT extends Abstractinstruction {

	int num;
	int devId;

	@Override
	public void execute(String instruction, CPU cpu, MCU mcu) throws MachineFaultException {
		this.num = StringUtil.binaryToDecimal(instruction.substring(6, 8));
		this.devId = StringUtil.binaryToDecimal(instruction.substring(11, 16));
		if (this.devId == Const.DevId.PRINTER.getValue()) {
			int val = cpu.getRnByNum(this.num);
			char c = (char) val;
			
			mcu.setPrinterBuffer(String.valueOf(c));
			
			cpu.increasePC();
		}
	}

	@Override
	public String getExecuteMessage() {
		return "OUT " + this.num + ", " + this.devId;
	}

}