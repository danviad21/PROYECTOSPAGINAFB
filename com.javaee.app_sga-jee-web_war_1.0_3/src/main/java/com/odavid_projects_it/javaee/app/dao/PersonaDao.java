/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid_projects_it.javaee.app.dao;

import com.odavid_projects_it.javaee.app.model.entity.Persona;
import java.util.List;

/**
 *
 * @author danvi
 */
public interface PersonaDao {
    
    public Persona create(Persona persona);
    
    public Persona update(Persona persona);
    
    public Persona findById(Long id);
    
    public Persona findByNombrePersonaOrApellido(String nombre, String apellido);
    
    public Persona findByEmailPersona(String email);
    
    public Persona findByTelefono(String telefono);
    
    public List<Persona> findAll();
    
    public void delete(Persona persona);
    
}
