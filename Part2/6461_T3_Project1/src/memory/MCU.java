/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.util.HashMap;
import java.util.Map;

import memory.Memory;

import memory.Cache.CacheLine;

/**
 *
 * @author yiqian
 */
public class MCU {
    
        Memory memory;
    	Cache cache;

	String printerBuffer;
	String keyboardBuffer;
	String cardBuffer;
    
        /**
         * inital MCU
         */
        public MCU(){
            this.memory = new Memory();
            this.cache = new Cache();
        }
        
        public Cache getCache(){
            return cache;
        }
        
        public String getKeyboardBuffer() {
            return keyboardBuffer;
	}

	public void setKeyboardBuffer(String keyboardBuffer) {
            this.keyboardBuffer = keyboardBuffer;
	}
        
        public String getCardBuffer() {
            return cardBuffer;
	}

	public void setCardBuffer(String cardBuffer) {
            this.cardBuffer = cardBuffer;
	}
        
        public String getPrinterBuffer() {
            return printerBuffer;
	}

	public void setPrinterBuffer(String printerBuffer) {
            this.printerBuffer = printerBuffer;
	}
        
        public void expandMemorySize(){
            this.memory.expandMemorySize();
        }
        
        public int getCurrentMemorySize(){
            return this.memory.getCurrentMemorySize();
        }
        
        public int fetchFromMemory(int address){
            return this.memory.fetchFromMemory(address);
        }
        
        public void storeInMemory(int address, int value){
            this.memory.storeInMemory(address, value);
        }
        /**
	 * 
	 * fetch a word from cache. If the word is not in cache, fetch it from
	 * memory, then store it into cache.
	 * 
	 * @param address
	 * @return
	 */
	public int fetchFromCache(int address) {
		for (CacheLine line : cache.getCacheLines()) { // check every block
														// whether the tag is
														// already exist
			if (address == line.getTag()) {
				return line.getData(); // tag exist, return the data of the
										// block
			}
		}
		// tag not exist
		int value = fetchFromMemory(address);
		cache.add(address, value);
		return value;
	}       
    
	/**
	 * store into cache with replacement. Also store into memory at same time.
	 * 
	 * @param address
	 * @param value
	 */
    	public void storeIntoCache(int address, int value) {
		storeInMemory(address, value);
		for (CacheLine line : cache.getCacheLines()) { // check every block the
														// tag is already exist
			if (address == line.getTag()) {
				line.setData(value); // replace the block
				return;
			}
		}
		// tag not exist
		cache.add(address, value);
	}
    
    
	/**
	 * Load program into Cache by address, value form
	 * 
	 * @param HashMap<String, Integer>
	 */
    	public void loadProgram(HashMap<String, Integer> program) {
		if (program != null) {
			for (Map.Entry<String, Integer> entry : program.entrySet()) {
				int address = Integer.parseInt(entry.getKey());
				int value = entry.getValue();
				storeIntoCache(address, value);
			}
		}
	}
}
