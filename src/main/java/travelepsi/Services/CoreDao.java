package travelepsi.Services;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
import travelepsi.Utils.HibernateUtil;

import java.io.Serializable;
import java.util.List;


public abstract class CoreDao<T> {

    protected Session session;
    protected Class<T> entityClass;

    public CoreDao(Class<T> entityClass) {
        session = HibernateUtil.getSessionFactory().openSession();
        this.entityClass = entityClass;
    }

    public List<T> getAll() {
        return createCriteria().list();
    }

    public T get(Integer id) {
        return (T) session.get(entityClass, id);
    }

    public T save(T obj) {
        session.beginTransaction();

        try {
            session.save(obj);
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            session = HibernateUtil.getSessionFactory().openSession();
        }

        session.getTransaction().commit();
        return (T) obj;
    }

    public T update(T obj) {
        session.beginTransaction();

        try {
            session.update(obj);
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            session = HibernateUtil.getSessionFactory().openSession();
        }

        session.getTransaction().commit();
        return (T) obj;
    }

    public T delete(T obj) {
        session.beginTransaction();

        try {
            session.delete(obj);
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
            session = HibernateUtil.getSessionFactory().openSession();

        }

        session.getTransaction().commit();
        return (T) obj;
    }

    public Criteria createCriteria() {
        return session.createCriteria(entityClass);
    }

}
