package com.nexus.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Pojo implements Serializable {

    private static final long serialVersionUID = 432493931162911L;

    public abstract Integer getId();


    public abstract void setId(Integer cod);
	private  HashMap<String, Object> dadosMap ;

     

    public boolean equals(Object other) {
    	//TODO: Fazer
        //Pojo castOther = (Pojo) other;
       // return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
    	return false;
    }

    public int hashCode() {
    	//TODO: Fazer
        //return new HashCodeBuilder().append(getId()).toHashCode();
    	return 1;
    }

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	  public HashMap<String, Object> getDadosMap() {
	    	if(dadosMap == null)
	    		dadosMap = new HashMap<String,Object>(0);
			return dadosMap;
		}
	  
	  public void setDadosMap(HashMap<String, Object> dados) {
			this.dadosMap = dados;
		}


	public void put(String campo,Object valor){
		getDadosMap().put(campo, valor);
	}
	
	public void remove(String string) {
		getDadosMap().remove(string);
	}
	
	public Object get(String campo){
		return getDadosMap().get(campo);
	}

	public boolean tem(String string) {
		return get(string)!=null;
	}

	@Override
	public String toString() {
		if(getId()!= null)
			return getId()+" ";
		else 
			return super.toString();
	}
	
}