/*
 * This file is part of the Soapbox Race World core source code.
 * If you use any of this code for third-party purposes, please provide attribution.
 * Copyright (c) 2020.
 */

package com.soapboxrace.core.dao;

import com.soapboxrace.core.dao.util.LongKeyedDAO;
import com.soapboxrace.core.jpa.CarSlotEntity;
import com.soapboxrace.core.jpa.PersonaEntity;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CarSlotDAO extends LongKeyedDAO<CarSlotEntity> {

    public CarSlotDAO() {
        super(CarSlotEntity.class);
    }

    public List<CarSlotEntity> findByPersonaId(Long personaId) {
        TypedQuery<CarSlotEntity> query = entityManager.createNamedQuery("CarSlotEntity.findByPersonaId",
                CarSlotEntity.class);
        query.setParameter("persona", personaId);
        return query.getResultList();
    }

    public CarSlotEntity findByPersonaIdEager(Long personaId, int index) {
        TypedQuery<CarSlotEntity> query = entityManager.createNamedQuery("CarSlotEntity.findByPersonaIdEager",
                CarSlotEntity.class);
        query.setParameter("persona", personaId);
        query.setFirstResult(index);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    public List<CarSlotEntity> findByPersonaIdEager(Long personaId) {
        TypedQuery<CarSlotEntity> query = entityManager.createNamedQuery("CarSlotEntity.findByPersonaIdEager",
                CarSlotEntity.class);
        query.setParameter("persona", personaId);
        return query.getResultList();
    }

    public Long findNumNonRentalsByPersonaId(Long personaId) {
        TypedQuery<Long> query = entityManager.createNamedQuery("CarSlotEntity.findNumNonRentalsByPersonaId",
                Long.class);
        query.setParameter("persona", personaId);
        return query.getSingleResult();
    }

    public int findNumByPersonaId(Long personaId) {
        TypedQuery<Long> query = entityManager.createNamedQuery("CarSlotEntity.findNumByPersonaId",
                Long.class);
        query.setParameter("persona", personaId);
        return query.getSingleResult().intValue();
    }

    public List<CarSlotEntity> findAllExpired() {
        TypedQuery<CarSlotEntity> query = entityManager.createNamedQuery("CarSlotEntity.findAllExpired",
                CarSlotEntity.class);
        return query.getResultList();
    }

    public void deleteByPersona(PersonaEntity personaEntity) {
        Query query = entityManager.createNamedQuery("CarSlotEntity.deleteByPersona");
        query.setParameter("persona", personaEntity);
        query.executeUpdate();
    }

}
