package spring.registration;

import spring.user.entity.User;
import spring.user_roles.entity.UserRole;

import java.io.Serializable;

public class RegisterModel implements Serializable {

    private User user;
    private UserRole userRole;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
