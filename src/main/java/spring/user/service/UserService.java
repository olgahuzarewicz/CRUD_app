package spring.user.service;

import spring.user.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User getUserByName(String username);

    User insertUser(User user);

    User deleteUser(String username);
}
