package rs.ac.bg.fon.ai.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import rs.ac.bg.fon.ai.dao.SubjectDao;
import rs.ac.bg.fon.ai.domain.Subject;
import rs.ac.bg.fon.ai.services.SubjectsService;
import rs.ac.bg.fon.ai.web.json.SubjectJsonConverter;

@Path("/subjects")
public class SubjectRestService {

	private SubjectDao subjectDao;
	private SubjectsService subjectsServices;

	public SubjectRestService() {
		subjectDao = new SubjectDao();
		subjectsServices = new SubjectsService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllSubjectsJson(@DefaultValue("") @QueryParam("query") String query,
			@DefaultValue("ASC") @QueryParam("order") String order,
			@DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("1") @QueryParam("page") int page) {
		List<Subject> subjects = subjectsServices.getAllSubjects(query, order, limit, page);

		return new Gson().toJson(subjects);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String getSubjectsByNameJson(@PathParam("name") String name) {
		List<Subject> subjects = subjectDao.listSubjectsByName(name);

		return new Gson().toJson(subjects);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertNewSubject(String subjectJson) {
		Subject subject = SubjectJsonConverter.deserializeSubject(subjectJson);
		subjectDao.insertNewSubject(subject);

		return Response.ok().build();
	}
}
