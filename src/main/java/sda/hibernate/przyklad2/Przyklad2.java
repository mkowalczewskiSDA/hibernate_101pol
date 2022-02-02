package sda.hibernate.przyklad2;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import sda.hibernate.model.Country;
import sda.hibernate.util.HibernateUtil;

public class Przyklad2 {
    public static void main(String[] args) {
        usePersist();
    }

//persist() zawsze tworzy nowy obiekt
//Służy do utrwalania obiektów. Jej wywołanie powoduje dołączenie przekazanego obiektu do zbioru obiektów zarządzanych oraz wywołanie INSERT
// w momencie zakończenia transakcji (albo wywołania flush). Jeżeli istnieje już encja o takim samym identyfikatorze dostaniemy wyjątek.
    public static void usePersist() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Country country = new Country();
        country.setAlias("IN");
        session.beginTransaction();
        session.persist(country);
        country.setName("India");
        session.flush();
        session.close();
    }

    public static void useMerge() {

    }
}
