package com.vortexbird.aws.s3;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;


/**
 * Este servicio sirve para ejecutar diferentes acciones sobre los Bucket s3 de Amazon el API es Cool
 * @author dgomez
 *
 */
@Component
public class S3Services implements IS3Services {
	
	private final static Logger log=LoggerFactory.getLogger(S3Services.class);

	
	@Autowired
	private VortexAWSCredentials vortexAWSCredentials;

	
	
	/**
	 * Crea un Bucket en AWS s3
	 */
	public void createBucket(String bucketName) throws Exception {
		AmazonS3 amazonS3 = buildAmazonS3();  
		 try {			  
			 log.info("Creating bucket " + bucketName + "\n");
			 amazonS3.createBucket(bucketName);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}finally {
			amazonS3=null;
		}
	}

	/**
	 * Carga el objecto sin permisos, queda de forma privada
	 * @param bucketName
	 * @param key
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public String uploadPrivate(String bucketName, String key, File file) throws Exception {
		log.info("Upload file:"+key+"			bucketName:" + bucketName + "\n");
		AmazonS3 amazonS3 = buildAmazonS3(); 
		 try {	 
			 amazonS3.putObject(new PutObjectRequest(bucketName, key, file));		 
			 return getUrl(bucketName, key);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}finally {
			amazonS3=null;
		}		
	}
	/**
	 * Carga el objecto con permisos de lectura a el publico
	 * @param bucketName
	 * @param key
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public String uploadPublicRead(String bucketName, String key, File file) throws Exception {
		log.info("Upload file:"+key+"			bucketName:" + bucketName + "\n");
		AmazonS3 amazonS3 = buildAmazonS3(); 
		 try {
			 amazonS3.putObject(new PutObjectRequest(bucketName, key, file).withCannedAcl(CannedAccessControlList.PublicRead));			 
			 return getUrl(bucketName, key);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}finally {
			amazonS3=null;
		}		
	}
	/*
	 * (non-Javadoc)
	 * @see com.vortexbird.aws.s3.IS3Services#download(java.lang.String, java.lang.String)
	 */
	public InputStream download(String bucketName, String key)throws Exception{
		AmazonS3 amazonS3 = buildAmazonS3(); 
		try {
		log.info("Download file:"+key+"			bucket " + bucketName + "\n");		
        		S3Object s3Object = amazonS3.getObject(new GetObjectRequest(bucketName, key));
        log.info("Content-Type: "  + s3Object.getObjectMetadata().getContentType()+"	Content-Length:"+s3Object.getObjectMetadata().getContentLength());
        return s3Object.getObjectContent();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}finally {
			amazonS3=null;
		}
	}
	/*
	 * Lista todos los Bucket de una cuenta de amazon AWS
	 * @see com.vortexbird.aws.s3.IS3Services#listBucketsName()
	 */
	@Override
	public List<String> listBucketsName() throws Exception {
		log.info("Listing buckets");
		AmazonS3 amazonS3 = buildAmazonS3(); 
		try {
			 List<String> listNames=new ArrayList<>();
		        for (Bucket bucket : amazonS3.listBuckets()) {
		        		listNames.add(bucket.getName());
		        }
				return listNames;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}finally {
			amazonS3=null;
		}
	}
	
	/*
	 * Borra un objecto de un Bucket
	 * @see com.vortexbird.aws.s3.IS3Services#deleteObject(java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteObject(String bucketName, String key) throws Exception {
		log.info("Deleting an object\n");
		AmazonS3 amazonS3 = buildAmazonS3(); 
		try {			
			amazonS3.deleteObject(bucketName, key);            
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}finally {
			amazonS3=null;
		}
	}

	/*
	 * Borra el Bucket s3 recuerde que debe estar vacio de lo contrario no lo borrara
	 * @see com.vortexbird.aws.s3.IS3Services#deleteBucket(java.lang.String)
	 */
	@Override
	public void deleteBucket(String bucketName) throws Exception {
		log.info("Deleting an Bucket\n");
		AmazonS3 amazonS3 = buildAmazonS3(); 
		try {			
			amazonS3.deleteBucket(bucketName);            
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}finally {
			amazonS3=null;
		}	
	}
	
	private AmazonS3 buildAmazonS3() {
		AmazonS3 s3 = AmazonS3ClientBuilder.standard()
		            .withCredentials(new AWSStaticCredentialsProvider(vortexAWSCredentials))
		            .withRegion(vortexAWSCredentials.getRegion())
		            .build();
		return s3;
	}
	/**
	 * Retorna el URL de un objecto
	 */
	@Override
	public String getUrl(String bucketName, String key) throws Exception {
		AmazonS3 amazonS3 = buildAmazonS3(); 
		try {			
			return  amazonS3.getUrl(bucketName, key).toString();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}finally {
			amazonS3=null;
		}
		
	}
}
