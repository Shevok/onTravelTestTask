package com.example.citycontrol.controller;

import com.example.citycontrol.dto.CityDto;
import com.example.citycontrol.entity.City;
import com.example.citycontrol.service.CityService;
import com.example.citycontrol.transformer.CityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CityTransformer cityTransformer;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<CityDto> createCity(@RequestBody @Valid CityDto cityDto) {
        CityDto createdCityDto = cityTransformer.toCityDto(cityService.create(cityTransformer.toCity(cityDto)));
        return new ResponseEntity<>(createdCityDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<CityDto> getOneCity(@RequestBody String name) {
        CityDto cityDto = cityTransformer.toCityDto(cityService.getOne(name));
        return new ResponseEntity<>(cityDto, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<CityDto>> getAllCities() {
        List<CityDto> cities = cityService.getAll().stream()
                .map(cityTransformer::toCityDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<CityDto> updateCategory(@RequestBody @Valid CityDto cityDto) {
        CityDto updatedCityDto = cityTransformer.toCityDto(cityService.update(cityTransformer.toCity(cityDto)));
        return new ResponseEntity<>(updatedCityDto, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<City> updateCategory(@RequestBody String name) {
        cityService.deleteOneById(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
