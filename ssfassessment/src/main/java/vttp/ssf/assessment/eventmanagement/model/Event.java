package sg.edu.nus.iss.ssfassessment.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event implements Serializable{

    @NotNull(message = "Name cannot be null")
    @Size(min = 5, max = 25, message = "Name must be between 2 and 32 characters")
    private String fullName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birth date must be a past date less than today")
    private Date birthdate;

    @Email(message = "Invalid Email Format")
    @Size(max = 30, message = "Email length exceeded 30 characters")
    @NotBlank(message = "Email is a mandatory field")
    private String email;

    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Invalid phone number entered")
    private String mobileNo;

    @Size(min = 3, max = 20, message = "You're only allow to order 1 to 3 tickers")
    private Integer ticketNum;

    @Override
    public String toString() {
        return "Event [Name of Event=" + event + ", No of Tickets=" + ticketsNum + "]";
    }

    public static Event create(JsonObject json){
        Event event=new Event();
        event.setEvent(json.getString("event"));
        ticket.setTicket(json.getInt("ticket"));
        return event;
    }

}

//Create event
//List events
//Track no of registeration to an event