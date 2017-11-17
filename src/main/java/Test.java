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
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			UserService userService = context.getBean("userService", UserService.class);
			
			//userService.test();
			
			User user = new User();
			user.setName("qqtest-" + System.currentTimeMillis());
			User insertedUser = userService.save(user);
			//compruebo si tienen la misma referencia. Confirmado, la tienen
			logger.info("[m:main]: user: " + user);
			logger.info("[m:main]: insertedUser: " + insertedUser);
			
//			List<User> users = userService.findAll();
//			logger.info("[m:main]: users: " + userService);
			
			/*
			List<User> users = userService.findAll();
			userService.delete(users.get(0).getId());
			*/
			
			
		} catch (Exception e) {
			logger.error("[m:main]", e);
		}
	}

}
