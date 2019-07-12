package com.example.citycontrol.service;

import com.example.citycontrol.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    City create(City city);

    City getOne(String name);

    List<City> getAll();

    City update(City city);

    void deleteOneById(String name);
}
