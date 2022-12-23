package com.gymLit.gymLit.models;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="training_division")
public class TrainingDivision {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @OneToOne(mappedBy="trainingDivision")
    private DayWeek dayWeek;

    public DayWeek getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(DayWeek dayWeek) {
        this.dayWeek = dayWeek;
    }

    @ManyToMany(mappedBy = "trainingDivisions", cascade = CascadeType.REMOVE)
    List<Exercises> exercises;
}
