package com.co.microservicio.monitory.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.stereotype.Component;



@Component
public class LoggerUtility {
	
	private Logger loggerUser;

	public  void logUser(String log) {  	       	    

	    try { 
	    	if(loggerUser==null) {
	    		loggerUser = Logger.getLogger("userLog");
	    		FileHandler fileHandler = new FileHandler("userLog.log"); 
		    	loggerUser.addHandler(fileHandler);
		    	SimpleFormatter formatter = new SimpleFormatter();  
		        fileHandler.setFormatter(formatter); 		        
	    	}
 
	        loggerUser.info(log);  
	        cvs(log);

	    } catch (SecurityException | IOException e) {  
	        
	    } 
 
	}
	
	private  void cvs(String log) {  	       	    

		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("user.csv", true);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			bfwriter.write(log+"\n");
			bfwriter.close();
		} catch (IOException e) {
			
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					
				}
			}
		}
 
	}
}
