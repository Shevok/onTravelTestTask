package utils;

import entity.City;
import repository.CityRepository;
import repository.impl.CityRepositoryImpl;

public class ResponseCreator {

    private final CityRepository cityRepository = new CityRepositoryImpl();

    public String getCityInfo(String name){
        City city = cityRepository.findOneById(name);
        if(city == null){
            return "Пока я не посетил этот город и не знаю, что о нем рассказать";
        }else {
            return city.getDescription();
        }
    }
}
