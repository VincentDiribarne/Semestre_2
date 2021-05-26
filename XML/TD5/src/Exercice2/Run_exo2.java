package Exercice2;

import java.io.IOException;

import org.json.JSONException;

import Exercice2.test_gson.Test_Gson;
import Exercice2.test_jackson.Test_Jackson;
import Exercice2.test_jsonjava.Test_JsonJava;

public class Run_exo2 {

	public static void main(String[] args) throws IOException, JSONException {

		// Gson
		Test_Gson.once();
		Test_Gson.array();

		// Jackson
		Test_Jackson.once();
		Test_Jackson.array();

		// JSON-Java (org.json) 
		Test_JsonJava.once();
		Test_JsonJava.array();

		System.out.println("======= END =======");
		
	}

}
