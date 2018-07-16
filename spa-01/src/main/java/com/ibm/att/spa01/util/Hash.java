package com.ibm.att.spa01.util;

import java.security.MessageDigest;

public class Hash {
    
    
    public byte[] generateHash(String valueStr, String algorithm){
	System.out.println(valueStr+"---<");
	try{
	    
	    MessageDigest md = MessageDigest.getInstance(algorithm);
	    md.update(valueStr.getBytes());
	    return md.digest();
	}catch(Exception ex){
	    System.out.println("Error on generateHash: "+ex.getMessage());
	    return null;
	}
	
	
    }
    
    
    public String translate2Hexadecimal(byte[] bytes){
	
	StringBuilder stb = new StringBuilder();
	
	for(int i = 0; i < bytes.length; i++){
	    
	    int high = ((bytes[i] >> 4) & 0xf) << 4;
	    int low = bytes[i] & 0xf;
	    
	    if(high == 0){
		stb.append("0");
	    }
	    stb.append(Integer.toHexString(high | low));
	    
	}
	return stb.toString();
    }

}
