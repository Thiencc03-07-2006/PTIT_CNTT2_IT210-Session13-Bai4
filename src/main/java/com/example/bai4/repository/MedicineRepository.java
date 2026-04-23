package com.example.bai4.repository;

import com.example.bai4.model.Medicine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public class MedicineRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Medicine> findExpiredMedicines() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Medicine m WHERE m.expiryDate < :currentDate";
        Query<Medicine> query = session.createQuery(hql, Medicine.class);
        query.setParameter("currentDate", new Date());
        return query.getResultList();
    }
}