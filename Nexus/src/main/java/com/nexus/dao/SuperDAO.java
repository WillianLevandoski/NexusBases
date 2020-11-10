package com.nexus.dao;

import org.hibernate.Session;

public class SuperDAO extends DAO {
	
	  public static Session getSession(){
	        return DAO.getSession();
	  }
	  
	  
	  
}
