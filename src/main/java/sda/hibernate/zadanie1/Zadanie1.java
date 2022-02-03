package sda.hibernate.zadanie1;

import sda.hibernate.dao.GenericDao;
import sda.hibernate.dao.GenericDaoImpl;
import sda.hibernate.model.Address;
import sda.hibernate.model.Country;

public class Zadanie1 {
    public static void main(String[] args) {
        GenericDao<Country>  countryDao = new GenericDaoImpl<>(Country.class);
        System.out.println(countryDao.findById(1));
        Country country = new Country();
        country.setAlias("DE");
        country.setName("Germany");
        countryDao.insertObject(country);

        countryDao.getAll().forEach(System.out::println);
        System.out.println("paginacja");
        countryDao.getAll(2, 0).forEach(System.out::println);
        System.out.println("strona 2");
        countryDao.getAll(2, 2).forEach(System.out::println);
    }
}
