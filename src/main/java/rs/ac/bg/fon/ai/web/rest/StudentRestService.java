package rs.ac.bg.fon.ai.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.ac.bg.fon.ai.dao.StudentDao;
import rs.ac.bg.fon.ai.web.json.StudentJsonConverter;

@Path("/students")
public class StudentRestService {

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllStudentsJson() {
		StudentDao studentDao = new StudentDao();
		return StudentJsonConverter.serializeStudentArray(studentDao.listAllStudents()).toString();
	}
}
