package com.gymLit.gymLit.repository;

import com.gymLit.gymLit.models.DayWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayWeekRepository extends JpaRepository<DayWeek, Long> {
}
