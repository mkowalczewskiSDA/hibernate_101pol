package sda.hibernate.dao;

import org.hibernate.Session;
import sda.hibernate.util.HibernateUtil;

import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {

    private Class<T> entityClass;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T result = session.find(entityClass, id);
        session.close();
        return result;
    }

    @Override
    public void insertObject(T t) {

    }

    @Override
    public void deleteObject(T t) {

    }

    @Override
    public void deleteObject(int id) {

    }

    @Override
    public void updateObject(T t, int id) {

    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public List<T> getAll(int maxResults, int firstResult) {
        return null;
    }
}
