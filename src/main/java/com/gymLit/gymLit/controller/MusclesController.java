package com.gymLit.gymLit.controller;

import com.gymLit.gymLit.dto.muscles.MusclesDto;
import com.gymLit.gymLit.models.Muscles;
import com.gymLit.gymLit.response.ResponseHandler;
import com.gymLit.gymLit.services.muscles.MusclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/muscles")
public class MusclesController {

    @Autowired
    MusclesService musclesService;

    @GetMapping("/list")
    public ResponseEntity<?> listMuscles(){
        try{
            List<Muscles> muscles = musclesService.listMuscles();

            return ResponseHandler.generateResponse("List muscles generate with success", HttpStatus.OK, muscles);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/store")
    public ResponseEntity<?> store(@RequestBody MusclesDto musclesDto){
        try{
            Muscles muscles = musclesService.store(musclesDto);

            return ResponseHandler.generateResponse("Muscle store with success", HttpStatus.OK, muscles);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
