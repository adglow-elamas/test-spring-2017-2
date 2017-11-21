package web;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MyWebApplicationInitializer implements WebApplicationInitializer {
	
	private final static Logger logger = LogManager.getLogger(MyWebApplicationInitializer.class);
	
	private String TMP_FOLDER = System.getProperty("java.io.tmpdir"); 
    private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;	

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		logger.info("[m:onStartup]TMP_FOLDER: " + TMP_FOLDER);
		
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		//appContext.setConfigLocation("/WEB-INF/classes/beans.xml");
		appContext.setConfigLocation("/WEB-INF/classes/beans-web.xml");
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		//para habilitar multipart
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER, 
		     MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
		dispatcher.setMultipartConfig(multipartConfigElement);		
	}


 }
