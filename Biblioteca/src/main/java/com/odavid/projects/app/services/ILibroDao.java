/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid.projects.app.services;

import com.odavid.projects.app.model.entity.Libros;
import java.util.List;

/**
 *
 * @author danvi
 */
public interface ILibroDao {
    
    public List<Libros> findAll();
    
    public List<Libros> findByTituloOrAutorOrTipo(String cadena1, String cadena2);
    
    public List<Libros> findByTituloAndAutorAndTipo(String cadena1, String cadena2);
}
