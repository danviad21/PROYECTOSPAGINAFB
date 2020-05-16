/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid.projects.app.controller;

import com.odavid.projects.app.model.entity.Libros;
import com.odavid.projects.app.services.ILibroDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author danvi
 */
@Named(value = "bkn_libro")
@SessionScoped
public class LibroView implements Serializable {

    private static final long serialVersionUID = 409851494685500661L;

    @Inject
    private ILibroDao libroDao;

    @Inject
    private TipoLibroView tipoView;

    private final String tituloVista = "LIBROS";

    private String campoBusquedad;

    private Libros libro;

    private List<Libros> listaLibros;

    @PostConstruct
    public void init() {
        this.libro = new Libros();
        this.listaLibros = this.libroDao.findAll();
    }

    public void setListaLibrosBy() {
        if (this.libro.getTitulo().isEmpty() && this.campoBusquedad == null) {
            System.out.println("if");
            this.listaLibros = this.libroDao.findAll();
        } else {
            System.out.println("else");
            if (this.libro.getTitulo().isEmpty()) {
                System.out.println("if else");
                this.libro.setTitulo(null);
                System.out.println(this.campoBusquedad);
                this.listaLibros = this.libroDao.findByTituloOrAutorOrTipo(this.libro.getTitulo(), this.campoBusquedad);
            }else if(this.campoBusquedad == null){
                this.listaLibros = this.libroDao.findByTituloOrAutorOrTipo(this.libro.getTitulo(), this.campoBusquedad);
            }else{
                this.listaLibros = this.libroDao.findByTituloAndAutorAndTipo(this.libro.getTitulo(), this.campoBusquedad);
            }
        }
    }

    public String getCampoBusquedad() {
        return campoBusquedad;
    }

    public void setCampoBusquedad(String campoBusquedad) {
        this.campoBusquedad = campoBusquedad;
    }

    public TipoLibroView getTipoView() {
        return tipoView;
    }

    public void setTipoView(TipoLibroView tipoView) {
        this.tipoView = tipoView;
    }

    public List<Libros> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libros> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

}
