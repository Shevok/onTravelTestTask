package com.example.citycontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityDto {

    @NotBlank(message = "City must have name")
    private String name;

    @NotBlank(message = "City must have description")
    private String description;
}
