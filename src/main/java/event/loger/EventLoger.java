package event.loger;

import event.Event;

import java.io.IOException;

public interface EventLoger {
      void logEvent(Event event) throws IOException;
}
