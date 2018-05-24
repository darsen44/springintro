package event.loger;

import event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CombineEventLoger implements EventLoger{

    @Autowired
    @Qualifier("combinedLoggers")
    private Collection<EventLoger> loggers;

    @Override
    public void logEvent(Event event) throws IOException {
        for (EventLoger loger:
              loggers) {
            loger.logEvent(event);
        }
    }
}
