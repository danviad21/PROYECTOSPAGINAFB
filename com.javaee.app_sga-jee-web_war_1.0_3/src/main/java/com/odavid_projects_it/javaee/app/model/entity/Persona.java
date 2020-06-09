/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid_projects_it.javaee.app.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danvi
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Persona.findAll",query = "SELECT p FROM Persona p")
})

public class Persona implements Serializable{
    
    private static final Long SERIALVERSIONUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;
        
    @Column(name = "nombre_persona")
    private String nombrePersona;
    
    @Column(name = "apellido_persona")
    private String apellidoPersona;

    @Column(name = "email_persona")
    private String emailPersona;
    
    @Column(name = "telefono_persona")
    private String telefonoPersona;
    
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Persona> usuarios;
    
    public Persona(){
        
    }

    public Persona(String nombrePersona, String apellidoPersona, String emailPersona, String telefonoPersona) {
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.emailPersona = emailPersona;
        this.telefonoPersona = telefonoPersona;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombrePersona=" + nombrePersona + ", apellidoPersona=" + apellidoPersona + ", emailPersona=" + emailPersona + ", telefonoPersona=" + telefonoPersona + '}';
    }
    
    
}
