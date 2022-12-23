package com.gymLit.gymLit.controller;

import com.gymLit.gymLit.dto.category.MusclesCategoryDto;
import com.gymLit.gymLit.models.MusclesCategory;
import com.gymLit.gymLit.response.ResponseHandler;
import com.gymLit.gymLit.services.musclesCategory.MusclesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/muscles-category")
public class MusclesCategoryController {

    @Autowired
    MusclesCategoryService musclesCategoryService;


    @GetMapping("/list")
    public ResponseEntity<?> listMuscles(){
        try{
            List<MusclesCategory> musclesCategories = musclesCategoryService.list();

            return ResponseHandler.generateResponse("List muscles generate with success", HttpStatus.OK, musclesCategories);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/store")
    public ResponseEntity<?> store(@RequestBody MusclesCategoryDto musclesCategoryDto){
        try{
            MusclesCategory musclesCategory = musclesCategoryService.store(musclesCategoryDto);

            return ResponseHandler.generateResponse("Muscle store with success", HttpStatus.OK, musclesCategory);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
