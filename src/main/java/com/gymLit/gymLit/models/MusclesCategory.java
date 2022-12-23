package com.gymLit.gymLit.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="muscles_category")
@Getter
@Setter
public class MusclesCategory {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @Column(nullable = false, unique = false, length = 30)
    private Boolean bigCategoryMuscle;

    @OneToMany(mappedBy="musclesCategory", cascade = CascadeType.REMOVE)
    private List<Muscles> muscles;

    public List<Muscles> getMuscles() {
        return muscles;
    }

    public void setMuscles(List<Muscles> muscles) {
        this.muscles = muscles;
    }
}
