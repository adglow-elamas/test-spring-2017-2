package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.User;
import service.UserService;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class UserController {
	
	private final static Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
    @RequestMapping("/test")
    public User test() {
//    	logger.info("[m:test]: userService: " + userService);
//    	logger.info("[m:test]: userService.getClass(): " + userService.getClass());
    	//userService.test();
    	
		User user = new User();
		user.setName("qqtest-" + System.currentTimeMillis());
		userService.save(user);
		return user;
    }	

    @RequestMapping(value = "/backend/users", method = RequestMethod.GET)
    public List<User> findAll() {
    	return userService.findAll();
    }	

    @RequestMapping(value = "/backend/users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
    	userService.delete(id);
    }	
    
    @RequestMapping(value = "/backend/users", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
//    	logger.info("[m:save]: user: " + user);
//    	logger.info("[m:save]: user.getName(): " + user.getName());
//    	logger.info("[m:save]: user.toString(): " + user.toString());
    	return userService.save(user);
    }
    
}
