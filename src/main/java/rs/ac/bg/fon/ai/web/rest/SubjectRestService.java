package rs.ac.bg.fon.ai.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.ac.bg.fon.ai.dao.SubjectDao;
import rs.ac.bg.fon.ai.web.json.SubjectJsonConverter;

@Path("/services")
public class SubjectRestService {

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllSubjectsJson() {
		SubjectDao subjectDao = new SubjectDao();
		return SubjectJsonConverter.serializeSubjectArray(subjectDao.getAllSubjects()).toString();
	}
}
