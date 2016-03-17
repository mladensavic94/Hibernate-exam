package rs.ac.bg.fon.ai.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rs.ac.bg.fon.ai.dao.SubjectDao;
import rs.ac.bg.fon.ai.web.json.SubjectJsonConverter;

@Path("/subjects")
public class SubjectRestService {

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllSubjectsJson() {
		SubjectDao subjectDao = new SubjectDao();
		return SubjectJsonConverter.serializeSubjectArray(subjectDao.getAllSubjects()).getAsString();
	}
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	public Response insertNewSubject(String subjectJson) {
		System.out.println(subjectJson);
		
		return Response.ok().build();
	}
}
