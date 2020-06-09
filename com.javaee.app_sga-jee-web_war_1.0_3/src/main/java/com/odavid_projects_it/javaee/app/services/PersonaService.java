/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid_projects_it.javaee.app.services;

import com.odavid_projects_it.javaee.app.model.entity.Persona;
import java.util.List;

/**
 *
 * @author danvi
 */
public interface PersonaService {

    public Persona crearPersona(Persona persona);

    public Persona actualizarPerons(Persona persona);

    public Persona findById(Long id);

    public Persona buscarPorNombrePersona_Apellido(String nombre, String apellido);

    public Persona buscarPorEmailPersona(String email);

    public Persona findByTelefono(String telefono);

    public List<Persona> index();

    public void delete(Persona persona);
}
