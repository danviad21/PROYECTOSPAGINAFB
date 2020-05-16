/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid.projects.app.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author danvi
 */
@Entity
@Table(name = "tipos_libros")
@NamedQueries({
    @NamedQuery(name = "TipoLibro.findAll", query = "SELECT t FROM TipoLibros t"),
})
public class TipoLibros implements Serializable{
    
    private static final long serialVersionUID = 4098514946395500761L;
    
    @Id
    @Column(name = "id_tipo")
    private Long idTipo;
    
    @Column(name = "tipo")
    private String descripcionTipo;
    
    public TipoLibros(){
        
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    @Override
    public String toString() {
        return "TipoLibros{" + "idTipo=" + idTipo + ", descripcionTipo=" + descripcionTipo + '}';
    }
}
