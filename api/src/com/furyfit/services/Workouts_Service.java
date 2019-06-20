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

import com.furyfit.dao.WorkoutDAO;
import com.furyfit.models.Workout;

@Path("workouts")
public class Workouts_Service {
	
	private static List<Workout> workoutsList = WorkoutDAO.getListOfWorkouts();

	@GET
	@Produces("application/json")
	public Response getAllWorkouts() {
		return Response.ok(workoutsList).header("Access-Control-Allow-Origin", "*").build();
	}
	
	@DELETE
	@Path("deleteworkout/{id}")
	@Produces("application/json")
	public Response deleteSelectedWorkout(@PathParam("id") int id) {
		WorkoutDAO.deleteWorkout(id);
		return Response.ok("Entrenamiento eliminado correctamente").header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	@PUT
	@Path("updateworkout/{id}/{name}/{type}/{description}")
	@Produces("application/json")
	public Response updateSelectedWorkout(@PathParam("id") int id, @PathParam("name") String name, @PathParam("type") String type, @PathParam("description") String desc) {
		WorkoutDAO.updateWorkout(id, name, type, desc);
		return Response.ok("Entrenamiento actualizado correctamente").header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	
	@POST
	@Path("createworkout/{id}/{name}/{type}/{description}")
	@Produces("application/json")
	public Response createNewDiet(@PathParam("id") int id, @PathParam("name") String name, @PathParam("type") String type, @PathParam("description") String desc) {
		WorkoutDAO.createWorkout(id, name, type, desc);
		return Response.ok("Entrenamiento creado correctamente").header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}

}
