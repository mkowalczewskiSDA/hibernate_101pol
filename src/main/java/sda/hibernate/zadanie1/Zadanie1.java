package sda.hibernate.zadanie1;

import sda.hibernate.dao.GenericDao;
import sda.hibernate.dao.GenericDaoImpl;
import sda.hibernate.model.Country;

public class Zadanie1 {
    public static void main(String[] args) {
        GenericDao<Country>  countryDao = new GenericDaoImpl<>(Country.class);
        System.out.println(countryDao.findById(1));
    }
}
