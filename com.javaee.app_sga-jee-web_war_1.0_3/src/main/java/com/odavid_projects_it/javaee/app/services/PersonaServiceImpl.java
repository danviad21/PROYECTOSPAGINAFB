/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid_projects_it.javaee.app.services;

import com.odavid_projects_it.javaee.app.dao.PersonaDao;
import com.odavid_projects_it.javaee.app.model.entity.Persona;
import com.odavid_projects_it.javaee.app.services.ws.PersonaServiceWs;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

/**
 *
 * @author danvi
 */

@Stateless
@WebService(endpointInterface = "com.odavid_projects_it.javaee.app.services.ws.PersonaServiceWs")
public class PersonaServiceImpl implements PersonaService, PersonaServiceWs{
    
    @Inject
    private PersonaDao personaDao;
    
    @Resource
    private SessionContext context;
    
    @Override
    public Persona crearPersona(Persona persona){
        return this.personaDao.create(persona);
    }

    @Override
    public Persona actualizarPerons(Persona persona) {
        return this.personaDao.update(persona);
    }
      
    @Override
    public Persona findById(Long id) {
        return this.personaDao.findById(id);
    }

    @Override
    public Persona buscarPorNombrePersona_Apellido(String nombre, String apellido) {
        return this.personaDao.findByNombrePersonaOrApellido(nombre, apellido);
    }

    @Override
    public Persona buscarPorEmailPersona(String email) {
        return this.personaDao.findByEmailPersona(email);
    }

    @Override
    public Persona findByTelefono(String telefono) {
        return this.personaDao.findByTelefono(telefono);
    }

    @Override
    public List<Persona> index() {
        return this.personaDao.findAll();
    }

    @Override
    public void delete(Persona persona) {
        this.personaDao.delete(persona);
    }

}
