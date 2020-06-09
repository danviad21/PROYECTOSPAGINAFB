/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid_projects_it.javaee.app.services.ws;

import com.odavid_projects_it.javaee.app.model.entity.Persona;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author danvi
 */

@WebService
public interface PersonaServiceWs {

    @WebMethod
    public List<Persona> index();
}
