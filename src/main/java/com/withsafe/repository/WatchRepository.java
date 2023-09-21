package com.withsafe.repository;

import com.withsafe.domain.device.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class WatchRepository {
    private final EntityManager em;

    public void save(Watch watch){
        em.persist(watch);
    }
    public Watch findOne(Long id){
        return em.find(Watch.class, id);
    }
    public List<Watch> findAll(){
        return em.createQuery("select w from Watch w",Watch.class)
                .getResultList();
    }
    public List<Watch> findByName(Long id){
        return em.createQuery("select w from Watch w where w.id = :id",Watch.class)
                .setParameter("id",id)
                .getResultList();
    }
}
