package co.com.endava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
public class Producto {
	
	private String book;
	private String title;
	private String author;
	private String ranked;

}
