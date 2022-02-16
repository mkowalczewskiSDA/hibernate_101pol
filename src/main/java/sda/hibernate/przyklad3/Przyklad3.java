package sda.hibernate.przyklad3;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.hibernate.model.Address;
import sda.hibernate.model.Country;
import sda.hibernate.util.HibernateUtil;

import java.util.List;


public class Przyklad3 {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Address> query = session.createQuery(
                "select c from Address c where c.id =:id",
                Address.class)
                .setParameter("id", 1);

        List<Address> addressList = query.getResultList();

        Query<Address> queryJoin = session.createQuery(
                "select a from Address a join a.country c where c.name = :countryName", Address.class)
                .setParameter("countryName", "Poland");

        List<Address> joinedAddressList = queryJoin.getResultList();
        System.out.println("test");
        Address address = joinedAddressList.get(0);
        Country country = new Country();
        country.setName("China");
        country.setAlias("CH");
        session.beginTransaction();
        session.persist(country);
        session.getTransaction().commit();
        session.close();
        System.out.println("");
        address.setCountry(country);
        System.out.println("");
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(address);
        session.getTransaction().commit();
        //System.out.println(joinedAddressList.get(0).getCountry().getName());
        session.close();
        System.out.println("test");
        HibernateUtil.getSessionFactory().close();
        System.out.println();
    }
}
