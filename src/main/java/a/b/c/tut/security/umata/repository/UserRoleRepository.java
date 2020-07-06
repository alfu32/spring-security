package a.b.c.tut.security.umata.repository;

import a.b.c.tut.security.umata.entity.UserRole;
import a.b.c.tut.security.umata.entity.UserRoleId;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class UserRoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public <S extends UserRole> S save(S entity) {
        entityManager.persist(entity);
        return entity;
    }
}
