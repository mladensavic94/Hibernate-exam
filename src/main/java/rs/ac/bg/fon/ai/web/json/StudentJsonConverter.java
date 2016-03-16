package rs.ac.bg.fon.ai.web.json;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import rs.ac.bg.fon.ai.domain.Student;

public class StudentJsonConverter {
	public static JsonArray serializeStudentArray(List<Student> list) {
		JsonArray jsonArray = new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			jsonArray.add(serializeStudent(list.get(i)));
		}

		return jsonArray;
	}

	public static String serializeStudent(Student student) {

		Gson gson = new GsonBuilder().create();
		return gson.toJson(student);
	}
}
