package Exercice2.test_gson;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Test_Gson {
	
	static public void once() throws IOException {
		Glass glass;
		System.out.println("======= Gson / once =======");
	
		// Serialize once
		glass = new Glass("Green");
		glass.drink();
		FileWriter f = new FileWriter("src\\Exercice2\\data\\gson_once.json");
		Gson g = new Gson();
		g.toJson(glass, f);
		f.flush();
		f.close();
		
		// Read once
		glass = g.fromJson(new FileReader("src\\Exercice2\\data\\gson_once.json"), Glass.class);
		glass.drink();
	}

	static public void array() throws IOException {
		
		System.out.println("======= Gson / array =======");

		// Serialize collection
		Glass[] glasses = new Glass[] { new Glass("Red"), new Glass("Blue") };
		for (Glass glass : glasses){glass.drink();}
		FileWriter f = new FileWriter("src\\Exercice2\\data\\gson_array.json");
		Gson g = new Gson();
		g.toJson(glasses, f);
		f.flush();
		f.close();

		// Read collection
		glasses = g.fromJson(new FileReader("src\\Exercice2\\data\\gson_array.json"), Glass[].class);
		for (Glass glass : glasses){glass.drink();}

	}

}
