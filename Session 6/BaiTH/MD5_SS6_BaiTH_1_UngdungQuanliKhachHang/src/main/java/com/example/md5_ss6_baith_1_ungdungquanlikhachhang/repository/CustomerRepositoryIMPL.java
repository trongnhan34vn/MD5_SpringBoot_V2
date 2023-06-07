package com.example.md5_ss6_baith_1_ungdungquanlikhachhang.repository;

import com.example.md5_ss6_baith_1_ungdungquanlikhachhang.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepositoryIMPL implements ICustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        String str_query = "select c from Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(str_query, Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        String str_query = "select c from Customer c where c.id =:id";
        TypedQuery<Customer> query = entityManager.createQuery(str_query, Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}
