package event.loger;

import event.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CombineEventLoger implements EventLoger{
    private List<EventLoger> loggers = new ArrayList<>();;

    public CombineEventLoger(List<EventLoger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        for (EventLoger loger:
              loggers) {
            loger.logEvent(event);
        }
    }
}
