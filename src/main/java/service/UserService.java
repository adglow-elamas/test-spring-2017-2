package service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import domain.User;

//@Service
public interface UserService {

	public void test();
	public User save(User user);
	public List<User> findAll();
	public void delete(Long id);
	public Page<User> findAll(Pageable pageable);
}
