/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid.projects.app.services;

import com.odavid.projects.app.model.entity.TipoLibros;
import java.util.List;

/**
 *
 * @author danvi
 */
public interface ITipoLibroDao {
    
    public List<TipoLibros> findAll();
}
