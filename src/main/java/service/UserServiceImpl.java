package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.entities.User;
import domain.repositories.read.UserReadRepository;
import domain.repositories.write.UserWriteRepository;
import web.UserController;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private final static Logger logger = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserReadRepository userReadRepository;
	
	@Autowired
	private UserWriteRepository userWriteRepository;
	

	@Override
	public void test() {
//    	logger.info("[m:test]: userRepository: " + userRepository);
//    	logger.info("[m:test]: userRepository.getClass(): " + userRepository.getClass());
	}

	@Override
	public User save(User user) {
		return this.userWriteRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return this.userReadRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		this.userWriteRepository.deleteById(id);
		
	}
}
