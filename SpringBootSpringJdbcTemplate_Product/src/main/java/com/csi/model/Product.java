package com.csi.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private int productId;
	
	private String productName;
	
	private double productPrice;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yy")
	private Date productDate;
}
