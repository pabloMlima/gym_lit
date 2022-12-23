package com.gymLit.gymLit.repository;

import com.gymLit.gymLit.models.Muscles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MusclesRepository extends JpaRepository<Muscles, Long> {

    @Query(
            value = "SELECT * FROM muscles WHERE name = :name LIMIT 1",
            nativeQuery = true
    )
    Optional<Muscles> findByMuscle(@Param("name") String name);
}
