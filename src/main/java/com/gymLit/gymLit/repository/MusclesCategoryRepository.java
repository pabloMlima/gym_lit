package com.gymLit.gymLit.repository;

import com.gymLit.gymLit.models.MusclesCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MusclesCategoryRepository extends JpaRepository<MusclesCategory, Long> {

    @Query(
            value = "SELECT * FROM muscles_category WHERE name = :name LIMIT 1",
            nativeQuery = true
    )
    Optional<MusclesCategory> findByMuscleCategory(@Param("name") String name);
}
