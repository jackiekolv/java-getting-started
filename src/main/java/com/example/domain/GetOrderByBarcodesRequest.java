package com.example.domain;

public class GetOrderByBarcodesRequest {
	String barcodes;
	public String getBarcodes(){
		return barcodes;
	}
	public void setBarcodes(String barcodes){
		this.barcodes = barcodes;
	}
}
