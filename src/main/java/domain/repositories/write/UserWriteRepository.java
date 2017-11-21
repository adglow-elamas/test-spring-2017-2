package domain.repositories.write;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.entities.User;

@Repository
public interface UserWriteRepository extends JpaRepository<User, Long> {

}
