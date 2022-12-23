package com.gymLit.gymLit.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="muscles")
@Getter
@Setter
public class Muscles implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @ManyToOne
    @JoinColumn(name = "muscles_category_id")
    private MusclesCategory musclesCategory;

    public MusclesCategory getMusclesCategory() {
        return musclesCategory;
    }

    public void setMusclesCategory(MusclesCategory musclesCategory) {
        this.musclesCategory = musclesCategory;
    }
}
