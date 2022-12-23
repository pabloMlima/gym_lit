package com.gymLit.gymLit.services.musclesCategory;


import com.gymLit.gymLit.dto.category.MusclesCategoryDto;
import com.gymLit.gymLit.exception.ExceptionBasic;
import com.gymLit.gymLit.models.MusclesCategory;
import com.gymLit.gymLit.repository.MusclesCategoryRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusclesCategoryImp implements MusclesCategoryService {

    @Autowired
    private MusclesCategoryRepository musclesCategoryRepository;

    @Override
    public List<MusclesCategory> list(){
        List<MusclesCategory> musclesCategories = musclesCategoryRepository.findAll();
        return musclesCategories;
    }
    @Override
    public MusclesCategory store(MusclesCategoryDto musclesCategoryDto) throws ConstraintViolationException, ExceptionBasic {
        Optional<MusclesCategory> searchMuscle = musclesCategoryRepository.findByMuscleCategory(musclesCategoryDto.getName());
        if(searchMuscle.isPresent()){
            throw new ExceptionBasic(ExceptionBasic.AlreadyExists());
        }
        MusclesCategory musclesCategory = new MusclesCategory();
        musclesCategory.setName(musclesCategoryDto.getName());
        musclesCategory.setBigCategoryMuscle(musclesCategoryDto.getBigCategoryMuscle());

        return musclesCategoryRepository.save(musclesCategory);
    }
}
