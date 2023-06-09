package com.myfavoritecoach.rest.webservices.Service;

import com.myfavoritecoach.rest.webservices.model.User;
import com.myfavoritecoach.rest.webservices.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findByRole(String description) {
        return userRepository.findByRole_Description(description);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        if(Objects.isNull(user.getId()) || userRepository.findById(user.getId()).isEmpty()){
            throw new RuntimeException("ex.user.object_not_found");
        }
        return userRepository.save(user);
    }

    public Long countByDescription(String description) {
        return userRepository.countAllByRole_Description(description);
    }

}
