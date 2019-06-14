package com.app;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Check {

	public static void main(String[] args) {
String s="Rohith";
		
		 try { 
			  
	            MessageDigest md = MessageDigest.getInstance("MD5"); 
	  
	            byte[] messageDigest = md.digest(s.getBytes()); 
	  
	            // Convert byte array into signum representation 
	            BigInteger no = new BigInteger(1, messageDigest); 
	  
	            System.out.println("no----"+no);
	            // Convert message digest into hex value 
	            String hashtext = no.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	            System.out.println(hashtext);
	            
	        }  
	  
	        // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        } 
	    } 
		
	}


