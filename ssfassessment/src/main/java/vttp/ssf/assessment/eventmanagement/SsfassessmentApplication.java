package vttp.ssf.assessment.eventmanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@SpringBootApplication
public class SsfassessmentApplication implements CommandLineRunner {

	private Logger logger = Logger.getLogger(SsfassessmentApplication.class.getName());
    
	@Autowired
	private EventRepo evRepo;
	public static void main(String[] args) {
		SpringApplication.run(SsfassessmentApplication.class, args);
	}
    
	@Override
	public void run(String... args) throws Exception {

		// read game.json file and save to redis
				File jsonFile = new File("./src/main/resources/static/events.json"); 

		String path = jsonFile.toPath().toAbsolutePath().toString();
		logger.log(Level.INFO, "++++++++++++++++ path is: " + path);

		if (jsonFile.exists()) {

			logger.log(Level.INFO, "++++++++++ file exist!!!!!!");

			Reader reader = new BufferedReader(new FileReader(jsonFile));
			JsonReader jsonReader= Json.createReader(reader);
			JsonArray jArray = jsonReader.readArray(); 
			JsonObject json;
			for(int i = 0; i < jArray.size(); i++){

				json = jArray.getJsonObject(i);
				evRepo.insertEvent(json);
			}

			logger.log(Level.INFO, "");

		}else{
			logger.log(Level.INFO, "File not found!");
		}
	}
}

// Task1,2
//implements CommlandLine Runner to execute the service funtion readFile
//displays list of events on console window
//loop thru the list of events from events.json file
// call service function saveRecord(Event event) to save the even in Redis
