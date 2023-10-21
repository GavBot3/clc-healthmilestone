package com.gcu.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class MedicineModel {

	public String name;
	public String type;
	public String strength;
	public int quantity;
	public int numServings;

	public MedicineModel(String name, String type, String strength, int quantity, int numServings) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.type = type;
		this.strength = strength;
		this.quantity = quantity;
		this.numServings = numServings;
	}

    public String getName() { 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getNumServings() {
		return numServings;
	}
	public void setNumServings(int numServings) {
		this.numServings = numServings;
	}
}


