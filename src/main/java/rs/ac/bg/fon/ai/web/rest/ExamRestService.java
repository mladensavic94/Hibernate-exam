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

import rs.ac.bg.fon.ai.dao.ExamDao;
import rs.ac.bg.fon.ai.domain.Exam;
import rs.ac.bg.fon.ai.web.json.ExamJsonConverter;

@Path("/exams")
public class ExamRestService {

	ExamDao examDao;

	public ExamRestService() {
		examDao = new ExamDao();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllExamsJson() {
		List<Exam> exams = examDao.getAllExams();
		return new Gson().toJson(exams);
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/passed")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPassedExamsJson() {
		List<Exam> exams = examDao.getAllPassed();
		return new Gson().toJson(exams);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertNewExam(String examJson) {
		Exam exam = ExamJsonConverter.deserializeExam(examJson);
		examDao.insertNewExam(exam);
		return Response.ok().build();
	}
}
