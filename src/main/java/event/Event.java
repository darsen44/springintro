package event;

import lombok.*;

import java.text.DateFormat;
import java.util.Date;
public class Event {
    private int id = (int) (Math.random()*100);
    @Setter
    @Getter
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.date = date;
        this.df = df;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
