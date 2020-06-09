/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid_projects_it.javaee.app.dao;

import com.odavid_projects_it.javaee.app.model.entity.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author danvi
 */
@Stateless
public class PersonaDaoImp implements PersonaDao{

    @PersistenceContext(unitName = "PersonaPU")
    private EntityManager em;
    @Override
    public Persona create(Persona persona1) {
         this.em.persist(persona1);
        return persona1;
    }

    @Override
    public Persona update(Persona persona) {
        return this.em.merge(persona);
    }

    @Override
    public Persona findById(Long id) {
        return this.em.find(Persona.class, id);
    }

    @Override
    public Persona findByNombrePersonaOrApellido(String nombre, String apellido) {
        Query query = this.em.createQuery("SELECT p FROM Persona p WHERE p.nombrePersona := 1? or p.apellidoPersona := 2?");
        query.setParameter(1, nombre);
        query.setParameter(2, apellido);
        return (Persona)query.getSingleResult();
    }

    @Override
    public Persona findByEmailPersona(String email) {
        Query query = this.em.createQuery("SELECT p FROM Persona p WHERE p.emailPersona = :email");
        query.setParameter("email", email);
        return (Persona)query.getSingleResult();
    }

    @Override
    public Persona findByTelefono(String telefono) {
        Query query = this.em.createQuery("SELECT p FROM Persona p WHERE p.telefonoPersona = :telefono");
        query.setParameter("telefono", telefono);
        return (Persona)query.getSingleResult();
    }

    @Override
    public List<Persona> findAll() {
        List<Persona> temp = em.createNamedQuery("Persona.findAll").getResultList();
        return em.createNamedQuery("Persona.findAll").getResultList(); 
    }

    @Override
    public void delete(Persona persona) {
        this.em.remove(em.merge(persona));
    }
    
}
