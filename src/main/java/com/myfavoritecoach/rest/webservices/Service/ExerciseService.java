package com.myfavoritecoach.rest.webservices.Service;

import com.myfavoritecoach.rest.webservices.model.Exercise;
import com.myfavoritecoach.rest.webservices.model.User;
import com.myfavoritecoach.rest.webservices.repository.ExerciseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ExerciseService {

    private ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    public Optional<Exercise> findById(Integer id) {
        return exerciseRepository.findById(id);
    }

    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercise updateExercise(Exercise exercise) {
        if (Objects.isNull(exercise.getId()) || exerciseRepository.findById(exercise.getId()).isEmpty()) {
            throw new RuntimeException("ex.exercise.object_not_found");
        }
        return exerciseRepository.save(exercise);
    }

    public Long count() {
        return exerciseRepository.count();
    }

}
