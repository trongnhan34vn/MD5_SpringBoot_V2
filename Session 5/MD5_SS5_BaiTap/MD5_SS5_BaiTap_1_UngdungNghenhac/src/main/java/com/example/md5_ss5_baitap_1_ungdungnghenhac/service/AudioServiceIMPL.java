package com.example.md5_ss5_baitap_1_ungdungnghenhac.service;

import com.example.md5_ss5_baitap_1_ungdungnghenhac.model.Audio;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AudioServiceIMPL implements IAudioService{
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Audio> findAll() {
        String STR_QUERY = "SELECT a FROM Audio AS a";
        TypedQuery<Audio> query = entityManager.createQuery(STR_QUERY, Audio.class);
        return query.getResultList();
    }

    @Override
    public void save(Audio audio) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if(audio.getAudioId() != 0) {
                Audio audio1 = findById(audio.getAudioId());
                audio1.setAudioName(audio.getAudioName());
                audio1.setArtist(audio.getArtist());
                audio1.setCategory(audio.getCategory());
                audio1.setUrl(audio.getUrl());
            }
            session.saveOrUpdate(audio);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Audio findById(int id) {
        String str_query = "Select a from Audio as a where a.audioId = :id";
        TypedQuery<Audio> query = entityManager.createQuery(str_query, Audio.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(findById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
