package com.gymLit.gymLit.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="exercises")
public class Exercises {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 45)
    private String name;

    @Column(nullable = false, unique = false, length = 30)
    private Boolean bigCategoryMuscle;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "exercises_training_divisions",
            joinColumns = @JoinColumn(name = "exercises_id"),
            inverseJoinColumns = @JoinColumn(name="training_divisions_id"))
    List<TrainingDivision> trainingDivisions;

    public List<TrainingDivision> getTrainingDivisions() {
        return trainingDivisions;
    }

    public void setTrainingDivisions(List<TrainingDivision> trainingDivisions) {
        this.trainingDivisions = trainingDivisions;
    }
}
