package sda.hibernate.przyklad1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sda.hibernate.model.Country;
import sda.hibernate.model.Order;
import sda.hibernate.model.User;

public class Przyklad1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Country country = session.find(Country.class, 1);
        System.out.println(country.getName());
        country.setName("Przyklad");
        session.close();
        sessionFactory.close();

        Order order = new Order();
        order.getUser();
        User user = new User();
        user.getOrders();


        System.out.println(country.getId());
    }
}
