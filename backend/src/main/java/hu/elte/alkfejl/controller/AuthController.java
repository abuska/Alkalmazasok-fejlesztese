package hu.elte.alkfejl.controller;
    
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.elte.alkfejl.annotation.Role;
import hu.elte.alkfejl.entity.User;
import hu.elte.alkfejl.service.SessionService;
import hu.elte.alkfejl.service.UserService;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;
    
    
    @Role({User.Role.GUEST})
    @PostMapping("/auth/login")
    public ResponseEntity<User> login(@Valid  @RequestBody String logindata) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node = objectMapper.readValue(logindata, JsonNode.class);
        String username = node.get("username").toString().replaceAll("\"", "");
        String pw = node.get("password").toString().replaceAll("\"", "");
        User currentUser = userService.getUserByUsernameAndPassword(username, pw);
        if (currentUser != null) {
            sessionService.setCurrentUser(currentUser);
            return ResponseEntity.ok(currentUser);
        }
        else {
            sessionService.setCurrentUser(null);
            return ResponseEntity.status(403).build();
        }
    }
    
    
    @Role({User.Role.ADMIN, User.Role.USER})
    @RequestMapping(value = "auth/logout", method = RequestMethod.GET)
    public ResponseEntity logout() {
        sessionService.setCurrentUser(null);
        return ResponseEntity.ok(false);
    }

    @Role(User.Role.GUEST)
    @RequestMapping(value = "/auth/registration", method = RequestMethod.POST)
    public String registration(@RequestBody User user) {
        return userService.createUser(user);
    }

    @Role({User.Role.ADMIN, User.Role.USER})
    @RequestMapping(value = "auth/user", method = RequestMethod.GET)
    public ResponseEntity getUser() {
        if (sessionService.getCurrentUser() == null) {
            return ResponseEntity.ok(false);
        } else {
            return ResponseEntity.ok(sessionService.getCurrentUser());
        }
    }
    
    @Role({User.Role.ADMIN, User.Role.USER})
    @RequestMapping(value = "auth/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable( required=true, value="id" ) String  id) throws IllegalArgumentException {
        User user = userService.getUserByID( Long.getLong(id)) ;
        if (user == null) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.ok(user);
        }
    }
}
