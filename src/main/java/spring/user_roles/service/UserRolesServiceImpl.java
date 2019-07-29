package spring.user_roles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.user_roles.entity.UserRole;
import spring.user_roles.repository.UserRolesDao;

@Service
@Transactional
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    private UserRolesDao userDao;

    @Override
    public UserRole insertUserRole(UserRole userRole) {
        return this.userDao.insertUserRole(userRole);
    }
}
