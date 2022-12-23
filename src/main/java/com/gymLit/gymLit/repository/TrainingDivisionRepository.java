package com.gymLit.gymLit.repository;

import com.gymLit.gymLit.models.TrainingDivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingDivisionRepository extends JpaRepository<TrainingDivision, Long> {
}
