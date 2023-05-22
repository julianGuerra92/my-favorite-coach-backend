package com.myfavoritecoach.rest.webservices.controller;

import com.myfavoritecoach.rest.webservices.Service.ExerciseService;
import com.myfavoritecoach.rest.webservices.model.Exercise;
import com.myfavoritecoach.rest.webservices.model.Role;
import com.myfavoritecoach.rest.webservices.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping()
    public ResponseEntity<List<Exercise>> findAll() {
        var exerciseList = exerciseService.findAll();
        return ResponseEntity.ok(exerciseList);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Optional<Exercise>> findById(@RequestParam Integer id) {
        var exercise = exerciseService.findById(id);
        if (exercise.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(exercise);
    }

    @GetMapping("/total-exercises")
    public ResponseEntity<Long> count() {
        var quantity = exerciseService.count();
        return ResponseEntity.ok(quantity);
    }

    @PostMapping("/create-exercise")
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        var newExercise = exerciseService.createExercise(exercise);
        return ResponseEntity.ok(newExercise);
    }

    @PutMapping("/update-exercise")
    public ResponseEntity<Exercise> updateExercise(@RequestBody Exercise exercise) {
        var updateExercise = exerciseService.updateExercise(exercise);
        return ResponseEntity.ok(updateExercise);
    }

}
