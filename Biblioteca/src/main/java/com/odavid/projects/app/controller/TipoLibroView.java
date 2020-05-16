/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid.projects.app.controller;

import com.odavid.projects.app.model.entity.TipoLibros;
import com.odavid.projects.app.services.ITipoLibroDao;
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

@Named(value = "bkn_tipo")
@SessionScoped
public class TipoLibroView implements Serializable{

    private static final long serialVersionUID = 409851494687500661L;
    
    private final String titulo = "TIPO DE LIBROS";
    
    @Inject
    private ITipoLibroDao tipoLibroDao;

    private TipoLibros tipo;
    
    public TipoLibroView(){}
    
    private List<TipoLibros> listaTiposLibros;
    
    @PostConstruct
    public void init(){
        this.listaTiposLibros = this.tipoLibroDao.findAll();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public TipoLibros getTipo() {
        return tipo;
    }

    public void setTipo(TipoLibros tipo) {
        this.tipo = tipo;
    }    

    public List<TipoLibros> getListaTiposLibros() {
        return listaTiposLibros;
    }

    public void setListaTiposLibros(List<TipoLibros> listaTiposLibros) {
        this.listaTiposLibros = listaTiposLibros;
    }
}
