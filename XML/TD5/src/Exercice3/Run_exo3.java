package Exercice3;


import Exercice2.test_jsonjava.Glass;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Run_exo3 {

	public static void main(String[] args) throws IOException, JSONException {
		//GSON
		System.out.println("======= GSON =======");
		Coffee[] coffees ;
		Gson g = new Gson();
		coffees = g.fromJson(new FileReader("src\\Exercice3\\data\\exo3_coffees.json"), Coffee[].class);
		for (Coffee coffee : coffees){
			System.out.println(coffee);
		}

		//JACKSON
		System.out.println("\n====== JACKSON ======");
		ObjectMapper mapper = new ObjectMapper();
		coffees = mapper.readValue(new File("src\\Exercice3\\data\\exo3_coffees.json"), Coffee[].class);
		for (Coffee coffee : coffees){
			System.out.println(coffee);
		}

		//JSON_JAVA
		System.out.println("\n===== JSON_JAVA =====");
		JSONTokener tokener = new org.json.JSONTokener(new FileReader("src\\Exercice3\\data\\exo3_coffees.json"));
		JSONArray a1 = new JSONArray(tokener);
		coffees = new Coffee[a1.length()];
		for (int i = 0; i < a1.length(); i++) {
			JSONObject o = a1.getJSONObject(i);
			coffees[i] = new Coffee(o.getString("id"), o.getString("name"), o.getDouble("price"));
		}
		for (Coffee coffee : coffees) {
			System.out.println(coffee);
		}


		//FIN
		System.out.println("\n======= END =======");
		
	}

}
