package repository.impl;

import entity.City;
import repository.CityRepository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class CityRepositoryImpl implements CityRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("persistence").createEntityManager();

    @Override
    public City findOneById(String name) {
        entityManager.getTransaction().begin();
        City city = entityManager.find(City.class, name);
        entityManager.getTransaction().commit();
        return city;
    }
}
