package com.gymLit.gymLit.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="day_week")
public class DayWeek {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 12)
    private String name;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinTable(name = "day_week_training_division",
            joinColumns = @JoinColumn(name = "day_week_id"),
            inverseJoinColumns = @JoinColumn(name = "training_division_id")
    )
    private TrainingDivision trainingDivision;

    public TrainingDivision getTrainingDivision() {
        return trainingDivision;
    }

    public void setTrainingDivision(TrainingDivision trainingDivision) {
        this.trainingDivision = trainingDivision;
    }
}
