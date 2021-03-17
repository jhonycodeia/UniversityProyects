package com.vortexbird.aws.s3;

import com.amazonaws.auth.AWSCredentials;


/**
 * Carga las credenciales configuradas en 
 * @author dgomez
 *
 */
public class VortexAWSCredentials implements AWSCredentials{
	
	private String AWSAccessKeyId;
	private String AWSSecretKey;
	private String region;
	

	public void setAWSSecretKey(String aWSSecretKey) {
		AWSSecretKey = aWSSecretKey;
	}

	public void setAWSAccessKeyId(String aWSAccessKeyId) {
		AWSAccessKeyId = aWSAccessKeyId;
	}

	@Override
	public String getAWSAccessKeyId() {
		return AWSAccessKeyId;
	}

	@Override
	public String getAWSSecretKey() {
		return AWSSecretKey;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
