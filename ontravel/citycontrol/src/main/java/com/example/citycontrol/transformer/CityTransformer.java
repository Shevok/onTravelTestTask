package com.example.citycontrol.transformer;

import com.example.citycontrol.dto.CityDto;
import com.example.citycontrol.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityTransformer {

    public CityDto toCityDto(City city){
        CityDto cityDto = new CityDto();
        cityDto.setName(city.getName());
        cityDto.setDescription(city.getDescription());
        return cityDto;
    }

    public City toCity(CityDto cityDto){
        City city = new City();
        city.setName(cityDto.getName());
        city.setDescription(cityDto.getDescription());
        return city;
    }
}
