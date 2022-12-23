package com.gymLit.gymLit.dto.muscles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
public class MusclesDto {

    private UUID id;
    private String name;
    private UUID musclesCategory;

}
