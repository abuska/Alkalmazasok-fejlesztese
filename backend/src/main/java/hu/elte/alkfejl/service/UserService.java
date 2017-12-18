package hu.elte.alkfejl.service;

import hu.elte.alkfejl.entity.User;
import hu.elte.alkfejl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionService sessionService;

    public User getUserByID(Long id) {
        return userRepository.findOne(id);
    }
    
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public String createUser(User user) {
        if (user.getName().equals("") || user.getUsername().equals("")  || user.getEmail().equals("")
                || user.getAddress().equals("") || user.getPassword().equals("")) {
            return "Minden mezőt kötelező kitölteni!";
        }
        else {
            String response = validateRegistrationDatas(user.getUsername(),  user.getPassword(),
                    user.getEmail(), user.getAddress());

            if (response.equals(" ")) {
                user.setRole(User.Role.USER);
                userRepository.save(user);
                return "";
            }
            else {
                return response;
            }
        }

    }

    private String validateRegistrationDatas(String username, String password, String email, String address) {
        if (userRepository.findByUsername(username) != null) {
            return "Ez a felhasználónév már foglalt! Kérem válasszon egy másikat!";
        }
        
        if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            return "Hibás email cím!";
        }
        if (address.equals(" ")){
            return "Hibás cím!";
        }

        return " ";
    }

    public String modifyUser(User user) {
        String respone = validateModifyDatas(user.getEmail());
        if (respone.equals("")) {
            User currentUser = sessionService.getCurrentUser();
            currentUser.setEmail(user.getEmail());
            currentUser.setAddress(user.getAddress());
            userRepository.save(currentUser);
            return "";
        }
        else {
            return respone;
        }
    }

    private String validateModifyDatas(String email) {
        if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            return "Hibás email cím!";
        }
        return "";
    }
}
