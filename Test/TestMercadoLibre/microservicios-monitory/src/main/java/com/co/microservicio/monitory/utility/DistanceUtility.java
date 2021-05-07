package com.co.microservicio.monitory.utility;

import org.springframework.stereotype.Component;

@Component
public class DistanceUtility {
	
	private final double AR_LONGITUDE = -58.4173;
	private final double AR_LATITUDE = 34.6118;
	
	
	public double distanciaCoord(double lat2, double lng2) {  
       
        double radioTierra = 6371;
        double dLat = Math.toRadians(lat2 - AR_LATITUDE);  
        double dLng = Math.toRadians(lng2 - AR_LONGITUDE);  
        double sindLat = Math.sin(dLat / 2);  
        double sindLng = Math.sin(dLng / 2);  
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)  
                * Math.cos(Math.toRadians(AR_LATITUDE)) * Math.cos(Math.toRadians(lat2));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distancia = radioTierra * va2;  
   
        return distancia;  
    }  

}
