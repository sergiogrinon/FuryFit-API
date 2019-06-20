package com.furyfit.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.furyfit.dao.UserDAO;
import com.furyfit.models.User;

@Path("users")
public class Users_Service {

	private static List<User> loggedUser;

	//Get logged in user (check if exist)
	@GET
	@Path("user/{username}")
	@Produces("application/json")
	public Response getLoggedUser(@PathParam("username") String username) {
		loggedUser = UserDAO.getLoggedUserIfExist(username);
		return Response.ok(loggedUser).header("Access-Control-Allow-Origin", "*").build();
	}

	//Create new user in the database, checking the username
	@POST
	@Path("user/{username}/{nombre}/{apellido}/{email}/{sexo}/{objetivo}/{cespeciales}/{edad}/{peso}/{altura}/{id}")
	@Produces("application/json")
	public Response createNewUser(@PathParam("username") String username, @PathParam("nombre") String nombre,
			@PathParam("apellido") String apellido, @PathParam("email") String email, @PathParam("sexo") String sexo,
			@PathParam("objetivo") String objetivo, @PathParam("cespeciales") String cespeciales,
			@PathParam("edad") int edad, @PathParam("peso") float peso, @PathParam("altura") float altura,
			@PathParam("id") int id) {
		
		/**
		 * Have to check if the username is already taken by another user and send KO if its like that.
		 * If not, insert the new user in the database*/
		
		return Response.ok(loggedUser).build();
	}
	
	//Update user data, checking username
	@PUT
	@Path("user/{username}/{nombre}/{apellido}/{email}/{sexo}/{objetivo}/{cespeciales}/{edad}/{peso}/{altura}/{id}")
	@Produces("application/json")
	public Response updateUserData(@PathParam("username") String username, @PathParam("nombre") String nombre,
			@PathParam("apellido") String apellido, @PathParam("email") String email, @PathParam("sexo") String sexo,
			@PathParam("objetivo") String objetivo, @PathParam("cespeciales") String cespeciales,
			@PathParam("edad") int edad, @PathParam("peso") float peso, @PathParam("altura") float altura,
			@PathParam("id") int id) {
		
		/**
		 * Have to check because im not gonna let the user change the username
		 */
		
		return Response.ok(loggedUser).build();
	}

}
