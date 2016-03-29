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

import rs.ac.bg.fon.ai.dao.StudentDao;
import rs.ac.bg.fon.ai.domain.Student;
import rs.ac.bg.fon.ai.services.StudentsService;
import rs.ac.bg.fon.ai.web.json.StudentJsonConverter;

@Path("/students")
public class StudentRestService {

	StudentDao studentDao;
	StudentsService studentServices;

	public StudentRestService() {
		studentDao = new StudentDao();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllStudentsJson(@DefaultValue("") @QueryParam("query") String query,
			@DefaultValue("ASC") @QueryParam("order") String order, @DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("1") @QueryParam("page") int page) {

		List<Student> students = studentServices.listAllStudents(query, order, limit, page);

		return new Gson().toJson(students);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String getStudentByIdJson(@PathParam("name") String name) {
		List<Student> list = studentDao.listStudentsByName(name);
		return new Gson().toJson(list);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertNewStudent(String studentJson) {
		Student student = StudentJsonConverter.deserializeStudent(studentJson);
		studentDao.insertNewStudent(student);
		return Response.ok().build();
	}
}
