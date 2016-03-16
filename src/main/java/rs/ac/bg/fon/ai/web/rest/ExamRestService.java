package rs.ac.bg.fon.ai.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rs.ac.bg.fon.ai.dao.ExamDao;
import rs.ac.bg.fon.ai.web.json.ExamJsonConverter;

@Path("/exams")
public class ExamRestService {

	@SuppressWarnings("unchecked")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllExamsJson() {
		ExamDao examDao = new ExamDao();

		return ExamJsonConverter.serializeExamArray(examDao.getAllExams()).toString();
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/passed")
	@Produces(MediaType.APPLICATION_JSON)
	public String getPassedExamsJson() {
		ExamDao examDao = new ExamDao();
		return ExamJsonConverter.serializeExamArray(examDao.getAllPassed()).toString();
	}
}
