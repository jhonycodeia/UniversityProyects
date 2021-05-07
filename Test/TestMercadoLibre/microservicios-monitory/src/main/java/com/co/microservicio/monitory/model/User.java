package com.co.microservicio.monitory.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString
@Builder
public class User {

	@Id
	private String id;
	
	private String userId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date hora;
	
	@PrePersist
	public void prePersist() {
		this.id= UUID.randomUUID().toString();
	}
}
