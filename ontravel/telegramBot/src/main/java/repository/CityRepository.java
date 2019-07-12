package repository;

import entity.City;

public interface CityRepository {

    City findOneById(String name);
}
