package com.co.microservicio.monitory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CountryDTO {

	private String countryCode;
	private String countryCode3;
	private String countryName;
	private String countryEmoji;
}
