package com.example.md5_ss6_baitap_2_jpa_pictureofday.repository;

import com.example.md5_ss6_baitap_2_jpa_pictureofday.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CommentRepositoryIMPL implements ICommentRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Comment> findByDate() {
        String QUERY_F_BY_DAY = "SELECT c FROM Comment AS c WHERE c.date = CURRENT_DATE ";
        TypedQuery<Comment> query = entityManager.createQuery(QUERY_F_BY_DAY, Comment.class);
        return query.getResultList();
    }

    @Override
    public void save(Comment comment) {
        if (comment.getId() != null) {
            entityManager.merge(comment);
        } else {
            entityManager.persist(comment);
        }

    }

    @Override
    public Comment findById(Long id) {
        String QUERY_F_BY_ID = "SELECT c FROM Comment AS c WHERE c.id=:id";
        TypedQuery<Comment> query = entityManager.createQuery(QUERY_F_BY_ID, Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
