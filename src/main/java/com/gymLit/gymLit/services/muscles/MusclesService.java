package com.gymLit.gymLit.services.muscles;

import com.gymLit.gymLit.dto.muscles.MusclesDto;
import com.gymLit.gymLit.exception.ExceptionBasic;
import com.gymLit.gymLit.models.Muscles;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface MusclesService {

    Muscles store(@RequestBody MusclesDto musclesDto) throws ExceptionBasic;
    List<Muscles> listMuscles() throws ExceptionBasic;
}
