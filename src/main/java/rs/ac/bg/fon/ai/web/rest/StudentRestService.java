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

import rs.ac.bg.fon.ai.dao.StudentDao;
import rs.ac.bg.fon.ai.domain.Student;
import rs.ac.bg.fon.ai.web.json.StudentJsonConverter;

@Path("/students")
public class StudentRestService {

	StudentDao studentDao;

	public StudentRestService() {
		studentDao = new StudentDao();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllStudentsJson() {

		List<Student> students = studentDao.listAllStudents();

		return new Gson().toJson(students);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertNewStudent(String studentJson) {
		Student student = StudentJsonConverter.deserializeStudent(studentJson);
		studentDao.insertNewStudent(student);
		return Response.ok().build();
	}
}
