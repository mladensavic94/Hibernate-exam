package rs.ac.bg.fon.ai.web.json;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import rs.ac.bg.fon.ai.domain.Exam;

public class ExamJsonConverter {
	public static JsonArray serializeExamArray(List<Exam> list) {
		JsonArray jsonArray = new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			jsonArray.add(serializeExam(list.get(i)));
		}

		return jsonArray;
	}

	public static String serializeExam(Exam exam) {

		Gson gson = new GsonBuilder().create();
		return gson.toJson(exam);
	}

	public static Exam deserializeExam(String examJson) {

		return new Gson().fromJson(examJson, Exam.class);
	}
}
