package rs.ac.bg.fon.ai.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import rs.ac.bg.fon.ai.dao.ExamDao;
import rs.ac.bg.fon.ai.dao.StudentDao;
import rs.ac.bg.fon.ai.dao.SubjectDao;
import rs.ac.bg.fon.ai.domain.Exam;
import rs.ac.bg.fon.ai.domain.Student;
import rs.ac.bg.fon.ai.domain.Subject;
import rs.ac.bg.fon.ai.services.ExamsService;
import rs.ac.bg.fon.ai.web.json.ExamJsonConverter;

@Path("/exams")
public class ExamRestService {

	ExamDao examDao;
	ExamsService examsService;

	public ExamRestService() {
		examDao = new ExamDao();
		examsService = new ExamsService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllExamsJson(@DefaultValue("") @QueryParam("query") String query,
			@DefaultValue("ASC") @QueryParam("order") String order, @DefaultValue("10") @QueryParam("limit") int limit,
			@DefaultValue("1") @QueryParam("page") int page) {
		List<Exam> exams = examsService.getAllExams(query,order,limit,page);
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

		SubjectDao subjectDao = new SubjectDao();
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.findByName(exam.getStudent().getName());
		Subject subject = subjectDao.getSubjectByName(exam.getSubject().getName());
		exam.setStudent(student);
		exam.setSubject(subject);
		examDao.insertNewExam(exam);
		return Response.ok().build();
	}
}
