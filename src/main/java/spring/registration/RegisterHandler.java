package spring.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spring.user.entity.User;
import spring.user.service.UserService;
import spring.user_roles.entity.UserRole;
import spring.user_roles.service.UserRolesService;

@Component
public class RegisterHandler {

    @Autowired
    UserService userService;

    @Autowired
    UserRolesService userRolesService;

    public RegisterModel init() {
        return new RegisterModel();
    }

    public void addUser(RegisterModel registerModel, User user) {
        registerModel.setUser(user);
    }

    public void addRole(RegisterModel registerModel, UserRole userRole) {
        registerModel.setUserRole(userRole);
    }

    public String chooseFlow(RegisterModel registerModel, UserRole userRole) {

        return userRole.getRole().equals("ROLE_USER") ? "ROLE_USER" : "ROLE_ADMIN";
    }

    public String saveAll(RegisterModel registerModel) {
        String transitionValue = "success";

        User user = registerModel.getUser();
        user.setEnabled(1);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String userPassword = user.getPassword();

        user.setPassword(passwordEncoder.encode(userPassword));

        userService.insertUser(user);

        String username = user.getUsername();

        user = userService.getUserByName(username);

        UserRole userRole = registerModel.getUserRole();
        userRole.setUserId(user.getUserId());
        userRole.setUsername(user.getUsername());

        userRolesService.insertUserRole(userRole);

        return transitionValue;
    }

}
