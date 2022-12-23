package com.gymLit.gymLit.services.musclesCategory;

import com.gymLit.gymLit.dto.category.MusclesCategoryDto;
import com.gymLit.gymLit.exception.ExceptionBasic;
import com.gymLit.gymLit.models.MusclesCategory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface MusclesCategoryService {

    List<MusclesCategory> list();

    MusclesCategory store(MusclesCategoryDto musclesCategoryDto) throws ConstraintViolationException, ExceptionBasic;
}
