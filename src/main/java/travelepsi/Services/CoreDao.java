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
        try {
            session.beginTransaction();
            List<T> req = createCriteria().list();
            session.getTransaction().commit();

            return req;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();

            return null;
        }
    }

    public T get(Integer id) {
        try {
            session.beginTransaction();
            T req = (T) session.get(entityClass, id);
            session.getTransaction().commit();

            return req;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();

            return null;
        }
    }

    public T save(T obj) {
        try {
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return (T) obj;
    }

    public T update(T obj) {
        try {
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return (T) obj;
    }

    public T delete(T obj) {
        try {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return (T) obj;
    }

    public Criteria createCriteria() {
        return session.createCriteria(entityClass);
    }

}
