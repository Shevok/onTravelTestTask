package com.example.citycontrol.service.impl;

import com.example.citycontrol.entity.City;
import com.example.citycontrol.repository.CityRepository;
import com.example.citycontrol.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City create(City city) {
        cityRepository.save(city);
        return city;
    }

    @Override
    public City getOne(String name) {
        return cityRepository.getOne(name);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City update(City city) {
        City updatedCity = getOne(city.getName());
        updatedCity.setName(city.getName());
        updatedCity.setDescription(city.getDescription());
        cityRepository.save(updatedCity);
        return updatedCity;
    }

    @Override
    public void deleteOneById(String name) {
        cityRepository.deleteById(name);
    }
}
