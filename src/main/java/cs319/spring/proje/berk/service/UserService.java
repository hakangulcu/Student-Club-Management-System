package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.User;
import cs319.spring.proje.berk.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void addNewUser(User user) {
        User userById = userRepository.findById(user.getId()).orElse(null);

        if(userById == null) {
            userRepository.save(user);
        }

        else {
            userById.setName(user.getName());
            userById.setSurname(user.getSurname());
            userById.setUserId(user.getUserId());
            userById.setEmail(user.getEmail());
            userById.setPassword(user.getPassword());
            /*
            userById.setManager(user.isManager());
            userById.setAdmin(user.isAdmin());
            userById.setAdvisor(user.isAdvisor());

             */
        }
    }

    public void deleteUser(Long id) {
        User userById = userRepository.findById(id).orElse(null);

        if(userById == null) {
            throw new IllegalStateException("user with id " + id + " does not exist");
        }

        else {
            userRepository.deleteById(id);
        }
    }

    public User getUser(Long id) {
        User userById = userRepository.findById(id).orElse(null);

        if(userById == null) {
            throw new IllegalStateException("user with id " + id + " does not exist");
        }

        else {
            return userById;
        }
    }
}
