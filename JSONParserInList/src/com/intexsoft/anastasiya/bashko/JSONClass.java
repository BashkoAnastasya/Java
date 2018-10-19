package com.intexsoft.anastasiya.bashko;

import java.util.List;

public class JSONClass {
	private String nameProperty;
	private List<?> val; 
	public JSONClass() {
		
	}
	 
    public JSONClass(String nameProperty, List<?> arg) { 
    	this.nameProperty=nameProperty;
        this.val = arg; 
    } 
  
    public List<?> getValue() { 
        return val; 
    }
    public String getNameProperty() {
    	return nameProperty;
    }

	public void setNameProperty(String nameProperty) {
		this.nameProperty = nameProperty;
	}

	public void setVal(List<?> val) {
		this.val = val;
	}    
    
}