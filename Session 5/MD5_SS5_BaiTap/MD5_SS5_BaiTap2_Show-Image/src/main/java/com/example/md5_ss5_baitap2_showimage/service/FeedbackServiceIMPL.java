package com.example.md5_ss5_baitap2_showimage.service;

import com.example.md5_ss5_baitap2_showimage.model.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FeedbackServiceIMPL implements IFeedbackService{
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }
    @Override
    public List<Feedback> findAll() {
        String QUERY_STR = "SELECT f FROM Feedback as f WHERE date = current_date()";
        TypedQuery<Feedback> feedbackTypedQuery = entityManager.createQuery(QUERY_STR, Feedback.class);
        return feedbackTypedQuery.getResultList();
    }

    @Override
    public void save(Feedback feedback) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (feedback.getId() != 0) {
                Feedback feedback1 = findById(feedback.getId());
                feedback1.setAuthor(feedback.getAuthor());
                feedback1.setMessage(feedback.getMessage());
                feedback1.setPoint(feedback.getPoint());
                feedback1.setCountLike(feedback.getCountLike());
            }
            session.saveOrUpdate(feedback);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Feedback findById(int id) {
        String QUERY_STR = "SELECT f FROM Feedback AS f WHERE id=:id";
        TypedQuery<Feedback> query = entityManager.createQuery(QUERY_STR, Feedback.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
