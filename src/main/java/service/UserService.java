package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.entities.User;

//@Service
public interface UserService {

	public void test();
	public User save(User user);
	public List<User> findAll();
	public void delete(Long id);
}
