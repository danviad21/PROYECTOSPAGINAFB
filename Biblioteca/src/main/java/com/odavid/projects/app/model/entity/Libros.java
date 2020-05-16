/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid.projects.app.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author danvi
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libros l"),
    @NamedQuery(name = "Libro.findByIdOrTituloOrAutorOrTipo", query = "SELECT l FROM Libros l WHERE l.titulo LIKE :cadena1 OR l.tipoLibro.descripcionTipo LIKE :cadena2"),
    @NamedQuery(name = "Libro.findByIdAndTituloAndAutorAndTipo", query = "SELECT l FROM Libros l WHERE l.titulo LIKE :cadena1 AND l.tipoLibro.descripcionTipo LIKE :cadena2")
})
public class Libros implements Serializable {

    private static final long serialVersionUID = 4098514946395500661L;
    
    @Id
    @Column(name = "id_libro")
    private Long idLibro;

    @Column(name = "titulo")
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo", nullable = false)
    private TipoLibros tipoLibro;

    public Libros() {
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoLibros getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(TipoLibros tipoLibro) {
        this.tipoLibro = tipoLibro;
    }
   
    @Override
    public String toString() {
        return "Libros{" + "idLibro=" + idLibro + ", titulo=" + titulo + ", tipoLibro=" + tipoLibro + '}';
    }
    
    
}
