package event;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
@Component
@Scope("prototype")
public class Event {
    private int id = (int) (Math.random()*100);

    @Autowired
    private Date date;

    @Autowired
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + df.format(date) +
                '}';
    }
}
