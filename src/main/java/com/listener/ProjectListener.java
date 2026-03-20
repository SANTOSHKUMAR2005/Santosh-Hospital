package com.listener;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.dao.AdminDAO;
import com.dao.AdminDAOImp;
import com.dao.Connectionfactory;
import com.dao.HospitalDAOImp;
import com.dao.OtpDao;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class ProjectListener implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	    Connectionfactory.closeDataSource();
	}
	
    @Override
    public void contextInitialized(ServletContextEvent sce) {
	     //database parameter

    	try {
        	ServletContext servletContext = sce.getServletContext();
        	
        	InputStream IS = servletContext.getResourceAsStream("/WEB-INF/config/Config.properties");
        	Properties properties=new Properties();
        	properties.load(IS);
        	
        	String driver=(String)properties.get("db_driver");
        	String url=(String)properties.get("db_url");
        	String user=(String)properties.get("db_username");
        	String pass=(String)properties.get("db_password");
        		
        	Connectionfactory.init(driver,url,user,pass);
     
        	}catch(IOException e) {
        		e.printStackTrace();
        	}
    	
//		String driver=System.getenv("db_driver");
//    	String url=System.getenv("db_url");
//    	String user=System.getenv("db_username");
//    	String pass=System.getenv("db_password");
//    	Connectionfactory.init(driver,url,user,pass);
    	
    	
    	//creating table
    	HospitalDAOImp hospitalDAOImp=new HospitalDAOImp();
    	hospitalDAOImp.createDoctorsTable();
    	hospitalDAOImp.createClientTable();
    	hospitalDAOImp.createAppointmentTable();
    	
    	AdminDAO adminDAO=new AdminDAOImp();
    	adminDAO.createAdminTable();
    	
    	OtpDao.creatOtpVerificationTable();
    	
   }

}
