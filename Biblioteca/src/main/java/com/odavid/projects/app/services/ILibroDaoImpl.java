/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid.projects.app.services;

import com.odavid.projects.app.model.entity.Libros;
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
public class ILibroDaoImpl implements ILibroDao{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BibliotecaPU");
    private final EntityManager em = emf.createEntityManager();
       
    @Override
    public List<Libros> findAll() {
        return this.em.createNamedQuery("Libro.findAll").getResultList();
    }

    @Override
    public List<Libros> findByTituloOrAutorOrTipo(String cadena1, String cadena2) {
        return this.em.createNamedQuery("Libro.findByIdOrTituloOrAutorOrTipo").setParameter("cadena1", "%"+cadena1+"%").setParameter("cadena2", "%"+cadena2+"%").getResultList();
    }

    @Override
    public List<Libros> findByTituloAndAutorAndTipo(String cadena1, String cadena2) {
        return this.em.createNamedQuery("Libro.findByIdAndTituloAndAutorAndTipo").setParameter("cadena1", "%"+cadena1+"%").setParameter("cadena2", "%"+cadena2+"%").getResultList();
    }
}
