package com.example.md5_baith_2_jpaprocedure.repository;

import com.example.md5_baith_2_jpaprocedure.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
@Transactional
public class CustomerRepositoryIMPL implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        return query.executeUpdate() == 0;
    }

}
