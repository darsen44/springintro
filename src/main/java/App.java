import client.Client;
import event.Event;
import event.EventType;
import event.loger.ConsoleEventLoger;
import event.loger.EventLoger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

public class App {
   private Client client ;
   private Event event;
   private Map<EventType,EventLoger> loggers;

    public App(Client client, Map<EventType,EventLoger> loggers, Event event) {
        this.client = client;
          this.loggers = loggers;
        this.event = event;
    }

    public void logEvent(EventType type) throws IOException {
        EventLoger loger = loggers.get(type);
        if(loger == null){
            loger = new ConsoleEventLoger();
            System.out.println("from null");
        }
        loger.logEvent(event);
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("App");
        app.logEvent( EventType.INFO);
        app.logEvent( EventType.ERROR);
        app.logEvent(null);
        ctx.close();
    }
}


