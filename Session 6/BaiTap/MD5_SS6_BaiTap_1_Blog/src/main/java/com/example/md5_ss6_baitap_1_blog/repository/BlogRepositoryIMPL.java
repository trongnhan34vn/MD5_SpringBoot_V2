package com.example.md5_ss6_baitap_1_blog.repository;

import com.example.md5_ss6_baitap_1_blog.model.Blog;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class BlogRepositoryIMPL implements IBlogRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        String QUERY_ALL = "SELECT b FROM Blog as b";
        TypedQuery<Blog> query = entityManager.createQuery(QUERY_ALL, Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        String QUERY_FINDID = "SELECT b FROM Blog AS b WHERE b.id =:id";
        TypedQuery<Blog> query = entityManager.createQuery(QUERY_FINDID, Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            entityManager.persist(blog);
        } else {
            entityManager.merge(blog);
        }
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }
}
