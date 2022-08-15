package com.MOJICT.IACFee.Util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.MOJICT.IACFee.Beans.CPIBean;

import org.apache.log4j.PropertyConfigurator;

public class ApplicationServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Initialising logging");
		ServletContext ctx = sce.getServletContext();
		String prefix = ctx.getRealPath("/");
		String sep = System.getProperty("file.separator");
		String file = "WEB-INF"+sep+"classes"+sep+"log4j.properties";
		PropertyConfigurator.configure(prefix+file);
		new CPIBean();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
