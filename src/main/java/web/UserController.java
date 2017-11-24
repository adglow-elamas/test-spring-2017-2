package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/backend/users-paged", method = RequestMethod.GET)
    public Page<User> findPage(
    		@RequestParam(value="page", defaultValue="0") int page,
    		@RequestParam(value="sort", defaultValue="name") String sort,
    		@RequestParam(value="sort.dir", defaultValue="desc") String sortDir
    		) {
    	Pageable pageable = PageRequest.of(page, 2, new Sort(sortDir.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sort));
    	return userService.findAll(pageable);
    }
    
    
    /*
    @RequestMapping(value = "/backend/users", method = RequestMethod.GET)
    public Page<User> findAll(Pageable pageable) {
    	logger.info("[m:save]: pageable: " + pageable);
    	return null;
    	//return userService.findAll();
    }
    */
    
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

    //test pagination and sorting
    @RequestMapping(value = "/backend/users/{page}", method = RequestMethod.GET)
    public Page<User> findAll(@PathVariable("page") int page) {
    	//Pageable pageable = new PageRequest(0,2);
    	//Pageable pageable = PageRequest.of(page, 2);//funciona
    	Pageable pageable = PageRequest.of(page, 2, new Sort(Sort.Direction.DESC, "name"));
    	return userService.findAll(pageable);
    }	

}
