package com.nexus.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

	SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");
	SimpleDateFormat formatter3 = new SimpleDateFormat("MM dd, yyyy");
	SimpleDateFormat formatter4 = new SimpleDateFormat("E, MMM dd yyyy");
	SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
	SimpleDateFormat formatter6 = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	static SimpleDateFormat dataBD = new SimpleDateFormat("yyyy-MM-dd");

	public  Date DataPadrao(String str) {
	    Date data =  null;
		try {
			data = formatter1.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	    return data;
	}
	
	public static  Date DataBD(String str) {
	    Date data =  null;
		try {
			data = dataBD.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	    return data;
	}
	


}
