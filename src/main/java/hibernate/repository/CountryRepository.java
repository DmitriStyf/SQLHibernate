package hibernate.repository;


import hibernate.model.Country;
import hibernate.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CountryRepository {

    private static SessionFactory sessionFactory;

    static {
        sessionFactory = SessionFactoryUtil.getSessionFactory();
    }

    public List<Country> getCountries() {
        List<Country> countries;
        Session session = sessionFactory.openSession();
        countries = session.createQuery("FROM Country", Country.class)
                .setMaxResults(50)
                .getResultList();
        session.close();
        return countries;
    }

    public Country getCountryByCode(String code) {
        Country country;
        Session session = sessionFactory.openSession();
        country = session.byId(Country.class).load(code);
        session.close();
        return country;
    }

    public void addCountry(Country country){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(country);
        transaction.commit();
        session.close();
    } // do continent as enum
}
