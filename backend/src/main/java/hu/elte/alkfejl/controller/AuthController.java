package hu.elte.alkfejl.controller;

import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.entity.User;
import hu.elte.alkfejl.service.SessionService;
import hu.elte.alkfejl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @Role({User.Role.GUEST, User.Role.ADMIN, User.Role.USER})
    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String pwd) {
        User currentUser = userService.getUserByUsername(username);
        if (BCrypt.checkpw(pwd, currentUser.getPassword())) {
            sessionService.setCurrentUser(currentUser);
            return "logged in";
        }
        else {
            return "bad credentials";
        }
    }

    @Role(User.Role.GUEST)
    @RequestMapping(value = "/auth/registration", method = RequestMethod.POST)
    public String registration(@RequestParam String name, @RequestParam String address,
                               @RequestParam String username, @RequestParam String password,
                               @RequestParam String email) {

    	User newUser = new User(name, address, username, password, email, "GUEST");
        if (userService.saveUser(newUser)!=null) {
            return "successfully create a new user";
        }
        else {
            return "bad datas";
        }
    }

}
