package com.vortexbird.aws.s3;

import java.io.File;
import java.io.InputStream;
import java.util.List;


public interface IS3Services {

	public void createBucket(String bucketName)throws Exception;
	
	public String uploadPrivate(String bucketName,String key, File file )throws Exception;
	public String uploadPublicRead(String bucketName,String key, File file )throws Exception;
	
	public List<String> listBucketsName()throws Exception;
	 
	public InputStream download(String bucketName, String key)throws Exception;
	 
	public void deleteObject(String bucketName, String key)throws Exception;
	 
	public void deleteBucket(String bucketName)throws Exception;
	
	public String getUrl(String bucketName, String key)throws Exception;

}
