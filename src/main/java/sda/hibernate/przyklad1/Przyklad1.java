package sda.hibernate.przyklad1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sda.hibernate.dao.GenericDao;
import sda.hibernate.model.*;

import java.util.Set;

public class Przyklad1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Order order = session.find(Order.class, 1);
        Set<Product> products = order.getProducts();
        products.forEach(product -> System.out.println(product.toString()));
        session.close();
        sessionFactory.close();
    }
}
