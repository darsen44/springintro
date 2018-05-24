package event.loger;

import event.Event;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("console")
public class ConsoleEventLoger implements EventLoger {
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
