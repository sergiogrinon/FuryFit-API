package com.furyfit.services;

import com.furyfit.dao.DietDAO;
import com.furyfit.models.*;
import com.google.gson.JsonObject;

import javax.ws.rs.*;

import java.util.List;
import javax.ws.rs.core.Response;


@Path("diets")
public class Diets_Service {
	private static List<Diet> dietList = DietDAO.getListOfDiets();
	JsonObject deleteOk = new JsonObject();
	JsonObject createOk = new JsonObject();
	JsonObject updateOk = new JsonObject();
	
	String deleteWell = "Dieta eliminada correctamente";
	String createWell = "Dieta creada correctamente";
	String updateWell = "Dieta modificada correctamente";

	@GET
	@Produces("application/json")
	public Response getAllDiets() {
		return Response.ok(dietList).header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	@DELETE
	@Path("deletediet/{id}")
	@Produces("application/json")
	public Response deleteSelectedDiet(@PathParam("id") int id) {
		DietDAO.deleteDiet(id);
		return Response.ok(deleteWell).header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	@PUT
	@Path("updatediet/{id}/{name}/{type}/{description}")
	@Produces("application/json")
	public Response updateSelectedDiet(@PathParam("id") int id, @PathParam("name") String name, @PathParam("type") String type, @PathParam("description") String desc) {
		updateOk.addProperty("response", updateWell);
		DietDAO.updateDiet(id, name, type, desc);
		return Response.ok("Dieta modificada correctamente").header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	@POST
	@Path("creatediet/{id}/{name}/{type}/{description}")
	@Produces("application/json")
	public Response createNewDiet(@PathParam("id") int id, @PathParam("name") String name, @PathParam("type") String type, @PathParam("description") String desc) {
		DietDAO.createDiet(id, name, type, desc);
		return Response.ok(createWell).header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}

}
