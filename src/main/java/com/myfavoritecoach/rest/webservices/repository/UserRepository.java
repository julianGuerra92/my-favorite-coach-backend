package com.myfavoritecoach.rest.webservices.repository;

import com.myfavoritecoach.rest.webservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findByRole_Description(String description);
    Long countAllByRole_Description(String description);

}
