package io.intellisense.test.app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataProvider {
    @JsonProperty("660") 
    private The660 the660;

    public The660 getThe660() { return the660; }
    public void setThe660(The660 value) { this.the660 = value; }
	public DataProvider() {
		super();
		the660 = new The660();
		// TODO Auto-generated constructor stub
	}
	
    
	
}
