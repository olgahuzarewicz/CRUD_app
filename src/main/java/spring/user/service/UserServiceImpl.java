package spring.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.user.entity.User;
import spring.user.repository.UserDao;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return this.userDao.getUserList();
    }

    @Override
    public User getUserByName(String username) {
        return this.userDao.getUserByName(username);
    }

    @Override
    public User insertUser(User user) {
        return this.userDao.insertUser(user);
    }

    @Override
    public User deleteUser(String username) {
        Optional<User> optional = Optional.of(getUserByName(username));
        return optional.isPresent() ? this.userDao.deleteUser(username) : null;
    }
}
