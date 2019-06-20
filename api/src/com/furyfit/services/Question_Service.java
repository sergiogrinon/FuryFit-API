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

import com.furyfit.dao.QuestionDAO;
import com.furyfit.models.Question;

@Path("faqs")
public class Question_Service {
	
	private static List <Question> faqsList = QuestionDAO.getListOfFAQs();

	@GET
	@Produces("application/json")
	public Response getAllInterestLinks() {
		return Response.ok(faqsList).header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	@DELETE
	@Path("deletefaq/{id}")
	@Produces("application/json")
	public Response deleteSelectedQuestion(@PathParam("id") int id) {
		QuestionDAO.deleteQuestion(id);
		return Response.ok("Pregunta eliminada correctamente").header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	@PUT
	@Path("updatefaq/{id}/{question}/{answer}")
	@Produces("application/json")
	public Response updateQuestion(@PathParam("id") int id, @PathParam("question") String question, @PathParam("answer") String answer) {
		QuestionDAO.updateFAQ(id, question, answer);
		return Response.ok("Pregunta actualizada correctamente").header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}
	
	@POST
	@Path("createfaq/{id}/{question}/{answer}")
	@Produces("application/json")
	public Response createNewQuestion(@PathParam("id") int id, @PathParam("question") String question, @PathParam("answer") String answer) {
		QuestionDAO.createFAQ(id, question, answer);
		return Response.ok("Pregunta creada correctamente").header("Access-Control-Allow-Origin", "*").build(); //Important to allow CORS
	}

}
