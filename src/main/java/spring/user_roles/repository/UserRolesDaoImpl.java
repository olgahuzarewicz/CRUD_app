package spring.user_roles.repository;

import org.springframework.stereotype.Repository;
import spring.user_roles.entity.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRolesDaoImpl implements UserRolesDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public UserRole insertUserRole(UserRole userRole) {
        entityManager.merge(userRole);
        return userRole;
    }
}
