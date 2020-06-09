/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.odavid_projects_it.javaee.app.services.rs;

import com.odavid_projects_it.javaee.app.model.entity.Persona;
import com.odavid_projects_it.javaee.app.services.PersonaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author danvi
 */
@Path("/personas")
@Stateless
public class PersonaServiceRs {

    @Inject
    private PersonaService personaService;

    @GET
    @Produces({MediaType.APPLICATION_XML})
    public List<Persona> listaPersona() {
        return this.personaService.index();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}")
    public Persona encontarPorId(@PathParam("id") Long id) {
        return this.personaService.findById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response agregarRegistro(Persona persona) {
        try {
            Persona persona1 = personaService.crearPersona(persona);
            return Response.ok().entity(persona1).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") Long id, Persona personaModficiada) {
        try {
            Persona actual = this.personaService.findById(id);
            if (actual != null || personaModficiada != null) {
                actual = this.personaService.actualizarPerons(personaModficiada);
                return Response.ok().entity(actual).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
