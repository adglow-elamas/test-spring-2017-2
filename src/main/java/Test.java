import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import domain.User;
import service.UserService;
import web.UserController;

public class Test {
	
	private final static Logger logger = LogManager.getLogger(Test.class);
	
	public static void main(String[] args) {
		try {
			//comentario de pruebas
			//logger.info("[m:main]: Principio");
			
			//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			ApplicationContext context = new ClassPathXmlApplicationContext("beans-process.xml");
			UserService userService = context.getBean("userService", UserService.class);
			
			//userService.test();
			
			User user = new User();
			user.setName("qqtest-" + System.currentTimeMillis());
			User insertedUser = userService.save(user);
			//compruebo si tienen la misma referencia. Confirmado, la tienen
			logger.info("[m:main]: user: " + user);
			logger.info("[m:main]: insertedUser: " + insertedUser);
			logger.info("[m:main]: Después de insertar usuario");
			
			//prueba de conexiones y pool con threads
//			for(int i=1; i<=50; i++) {
//				Thread thread = new Thread(new Runnable() {
//					@Override
//					public void run() {
//						User user = new User();
//						user.setName("qqtest-" + System.currentTimeMillis());
//						User insertedUser = userService.save(user);
//						logger.info("[m:main]: user: " + user);
//						logger.info("[m:main]: insertedUser: " + insertedUser);
//						logger.info("[m:main]: Después de insertar usuario");
//						logger.info("[m:main]: Antes del sleep particular");
//						try {
//							Thread.sleep(1000*60*1);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						logger.info("[m:main]: Despues del sleep particular");
//					}
//					
//				});
//				thread.start();
//			}
			
			
//			List<User> users = userService.findAll();
//			logger.info("[m:main]: users: " + userService);
			
			/*
			List<User> users = userService.findAll();
			userService.delete(users.get(0).getId());
			*/
			
//			logger.info("[m:main]: Antes del sleep general");
//			Thread.sleep(1000*60*2);
//			logger.info("[m:main]: Despues del sleep general");
//			logger.info("[m:main]: Fin");
			
			
		} catch (Exception e) {
			logger.error("[m:main]", e);
		}
	}

}
