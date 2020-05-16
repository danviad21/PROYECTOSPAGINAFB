/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid.projects.app.services;

import com.odavid.projects.app.model.entity.TipoLibros;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author danvi
 */

@Stateless
public class ITipoLibroDaoImpl implements ITipoLibroDao{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
    private final EntityManager em = emf.createEntityManager();
    
    @Override
    public List<TipoLibros> findAll() {
        return this.em.createNamedQuery("TipoLibro.findAll").getResultList();
    }
    
}
