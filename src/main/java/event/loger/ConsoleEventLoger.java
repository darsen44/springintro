package event.loger;

import event.Event;

public class ConsoleEventLoger implements EventLoger {
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
