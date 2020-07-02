package a.b.c.tut.security.umata.repository;

import a.b.c.tut.security.umata.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
