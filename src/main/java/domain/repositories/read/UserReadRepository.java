package domain.repositories.read;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.entities.User;

@Repository
public interface UserReadRepository extends JpaRepository<User, Long> {

}
