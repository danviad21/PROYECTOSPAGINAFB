/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid_projects_it.javaee.app.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author danvi
 */

@Entity
public class Usuario implements Serializable{
    
    private static final Long SERIALVERSIONUID=1L;
    
    @Id
    @Column(name = "id_usuario")
    private Long idUsuario;
    
    private String username;

    @Column(name = "user_password")
    private String userPass;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    
    public Usuario(){
        
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
