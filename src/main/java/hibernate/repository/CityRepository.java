package hibernate.repository;

import hibernate.model.City;
import hibernate.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = SessionFactoryUtil.getSessionFactory();
    }

    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        Session session = sessionFactory.openSession();
        cities = session.createQuery("FROM City",City.class).setMaxResults(50).getResultList();
        session.close();
        return cities;
    }

        public City getCityById (Integer id) {
        City city = new City();
            Session session = sessionFactory.openSession();
            city = session.byId(City.class).load(id);
            session.close();
        return city;
    }
    public void addCity(City city){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();

    }

    public void deleteCity(Integer id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        City city = getCityById(id);
        if (city !=null){
            session.delete(city);
        }
        transaction.commit();
        session.close();
    }

    public void updateCityName (Integer id, String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        City city = session.byId(City.class).load(id);
        city.setName(name);
        transaction.commit();
        session.close();
    }
}

