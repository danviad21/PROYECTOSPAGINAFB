/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid_projects_it.javaee.app.controller;

import com.odavid_projects_it.javaee.app.model.entity.Persona;
import com.odavid_projects_it.javaee.app.services.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danvi
 */

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    
    @Inject
    private PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Persona> listaPersona = this.personaService.index();
        System.out.println("LA CANTIDAD DE PERSONA ES: "+listaPersona.size());
        System.out.println("Personas: "+listaPersona);
        request.setAttribute("personas", listaPersona);
        request.getRequestDispatcher("/ListadoPersonas.jsp").forward(request, response);
    }
}
