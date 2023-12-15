package sg.edu.nus.iss.ssfassessment.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;
import vttp.ssf.assessment.eventmanagement.controller.EventController;

@Service
public class DatabaseService {

	@Autowired
	private EventRepo evRepo;

	private Event parseEventObject(JSONObject jsonEvent) {
		Event event = new LisEvent();

		JSONObject jsonEmployeeObject = (JSONObject) jsonEvent.get("event");
		System.out.println(jsonEmployeeObject);

		event.setEventId(jsonEventObject.get("eventId").toString());
		event.setEventName(jsonEventObject.get("eventName").toString());
		event.setEventSize(Integer.parseInt(jsonEventObject.get("eventSize").toString()));
		event.setEventDate(jsonEventObject.get("eventDate").toString());
		event.setParticipantsCount(Integer.parseInt(jsonEventObject.get("participantsCount]").toString()));

		return event;
	}
	public String generateUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, 8);
    }
}

// Task1,2
//implements CommlandLine Runner to execute the service funtion readFile
//displays list of events on console window
//loop thru the list of events from events.json file
// call service function saveRecord(Event event) to save the even in Redis
