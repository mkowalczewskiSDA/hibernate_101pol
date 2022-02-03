package sda.hibernate.przyklad3;

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

        session.close();

        System.out.println("test");
        HibernateUtil.getSessionFactory().close();
        System.out.println();
    }
}
