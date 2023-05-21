package com.myfavoritecoach.rest.webservices.repository;

import com.myfavoritecoach.rest.webservices.model.Role;
import com.myfavoritecoach.rest.webservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    List<User> findByRole_Description(String description);

}
