package com.myfavoritecoach.rest.webservices.repository;

import com.myfavoritecoach.rest.webservices.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

}
