package spring.user.repository;

import spring.user.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    User getUserByName(String username);

    User insertUser(User user);

    User deleteUser(String username);
}
