package com.MOJICT.IACFee.Util;

import java.io.FileInputStream;
import java.util.Properties;



public class Readprops {
	
	public static void initprops(){
	try{
	final Properties props = new Properties();
	FileInputStream in=null;
	in = new FileInputStream("config.properties");
	System.out.println(">>>>>>>>>");
	props.load(in);
	System.out.println(">>>>>>>>>"+props.getProperty("PDFs"));
	System.out.println("cmg here before storecontext");
	//this.storeContext = new Context(props);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}

	public static void main(String args[])
	{
		initprops();
	}
}
