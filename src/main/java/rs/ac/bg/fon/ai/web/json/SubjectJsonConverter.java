package rs.ac.bg.fon.ai.web.json;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import rs.ac.bg.fon.ai.domain.Subject;

public class SubjectJsonConverter {
	public static JsonArray serializeSubjectArray(List<Subject> list) {
		JsonArray jsonArray = new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			jsonArray.add(serializeSubject(list.get(i)));
		}

		return jsonArray;
	}

	public static String serializeSubject(Subject subject) {

		Gson gson = new GsonBuilder().create();
		return gson.toJson(subject);
	}
}
