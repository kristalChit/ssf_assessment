package sg.edu.nus.iss.ssfassessment.repositories;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.Resource;
import jakarta.json.stream.JsonParser.Event;
import jakarta.validation.OverridesAttribute.List;

@Repository
public class RedisRepo {

    @Autowired 
    private DatabaseService databaseService;

    RedisTemplate<String, String> template;

    private String hashRef = "events";

    @Resource(name="redisEmployeeTemplate")
    private ListOperations<String, Event> hOps;

    public void saveRecord(java.util.List<Event> events) {
        hOps.put(hashRef, events.getEvents().toString(), events);
    }
    
    public Event getNumberofEvents(String string) {
        Event e = hOps.get(hashRef, String.valueOf(string));
        return e;
    }

    public Map<String, Event> getAll() {
        return null;
    }
}
    

//Task1&&2
// implements CommlandLine Runner to execute the service funtion readFile(String fileName)
// this shoul displays list of events on console window 
// this should loop thru the list of events from events.json file
// call service function saveRecord(Event event) to save the even in Redis

//Task2
// write function named saveRecord(Event event) tt saves event objects to Redis

//Task3
// write function named getNumberofEvents() tt returns the size of event list in Redis

//Task4
// Write function named getEvent(Integer index) tt returns event object at a particular index from the event list in Redis