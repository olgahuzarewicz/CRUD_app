package spring.user.repository;

import org.springframework.stereotype.Repository;
import spring.user.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        String queryStr = "select user from User user";
        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        return query.getResultList();
    }

    @Override
    public User getUserByName(String username) {
        String queryStr = "select user from User user where user.username = :name";
        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);
        return query.setParameter("name", username).getResultList().get(0);
    }

    @Override
    public User insertUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public User deleteUser(String username) {
        User user = entityManager.find(User.class, username);
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        }
        return user;
    }
}
