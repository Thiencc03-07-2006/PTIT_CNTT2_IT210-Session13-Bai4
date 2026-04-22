package com.example.bai4.repository;

import com.example.bai4.model.Medicine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicineRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Medicine> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                            "FROM Medicine m WHERE m.name = :name", Medicine.class)
                    .setParameter("name", name)
                    .list();
        }
    }
}