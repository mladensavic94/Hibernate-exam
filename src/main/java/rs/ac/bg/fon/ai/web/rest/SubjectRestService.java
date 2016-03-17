package rs.ac.bg.fon.ai.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import rs.ac.bg.fon.ai.dao.SubjectDao;
import rs.ac.bg.fon.ai.domain.Subject;
import rs.ac.bg.fon.ai.web.json.SubjectJsonConverter;

@Path("/subjects")
public class SubjectRestService {

	private SubjectDao subjectDao;
	
	public SubjectRestService() {
		subjectDao = new SubjectDao();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllSubjectsJson() {
		List<Subject> subjects = subjectDao.getAllSubjects();

		return new Gson().toJson(subjects);
	}
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	public Response insertNewSubject(String subjectJson) {
		System.out.println(subjectJson);
		
		return Response.ok().build();
	}
}
