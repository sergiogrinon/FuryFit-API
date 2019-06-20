package com.furyfit.services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.furyfit.dao.InterestLinksDAO;
import com.furyfit.models.InterestLink;

@Path("interestlinks")
public class Interest_Links_Service {
	private static List <InterestLink> linksList = InterestLinksDAO.getListOfInterestLinks();

	@GET
	@Produces("application/json")
	public Response getAllInterestLinks() {
		return Response.ok(linksList).header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	@DELETE
	@Path("deleteintlink/{id}")
	@Produces("application/json")
	public Response deleteSelectedLink(@PathParam("id") int id) {
		//Method that deletes the selected diet
		InterestLinksDAO.deleteInterestingLink(id);
		return Response.ok("Enlace de interés eliminado correctamente").header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	@POST
	@Path("createlink/{id}/{url}/{src}")
	@Produces("application/json")
	public Response createNewLink(@PathParam("id") int id, @PathParam("url") String url, @PathParam("src") String src) {
		InterestLinksDAO.createIntrLink(id, url, src);
		return Response.ok("Enlace de interés creado correctamente").header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	@PUT
	@Path("updatelink/{id}/{url}/{src}")
	@Produces("application/json")
	public Response updateSelectedLink(@PathParam("id") int id, @PathParam("url") String url, @PathParam("src") String src) {
		InterestLinksDAO.updateLink(id, url, src);
		return Response.ok("Enlace de interés modificado correctamente").header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}

}
