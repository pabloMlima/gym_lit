package com.gymLit.gymLit.services.muscles;


import com.gymLit.gymLit.dto.muscles.MusclesDto;
import com.gymLit.gymLit.exception.ExceptionBasic;
import com.gymLit.gymLit.models.Muscles;
import com.gymLit.gymLit.models.MusclesCategory;
import com.gymLit.gymLit.repository.MusclesRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusclesServiceImp implements MusclesService {

    @Autowired
    MusclesRepository musclesRepository;

    @Override
    public Muscles store(MusclesDto musclesDto) throws ConstraintViolationException, ExceptionBasic {
        Optional<Muscles> searchMuscle = musclesRepository.findByMuscle(musclesDto.getName());
        if(searchMuscle.isPresent()){
            throw new ExceptionBasic(ExceptionBasic.AlreadyExists());
        }
        Muscles muscles = new Muscles();
        MusclesCategory musclesCategory = new MusclesCategory();
        musclesCategory.setId(musclesDto.getMusclesCategory());

        muscles.setName(musclesDto.getName());
        muscles.setMusclesCategory(musclesCategory);

        return musclesRepository.save(muscles);
    }

    @Override
    public List<Muscles> listMuscles() throws ExceptionBasic {
        List<Muscles> result = musclesRepository.findAll();
        return result;
    }
}
