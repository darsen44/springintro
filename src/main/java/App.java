import client.Client;
import config.AppConfig;
import config.LoggerConfig;
import event.Event;
import event.EventType;
import event.loger.ConsoleEventLoger;
import event.loger.EventLoger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class App {

    @Autowired
   private Client client ;

    @Autowired
   private Event event;

   @Autowired
   @Qualifier("loggerMap")
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
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class, LoggerConfig.class);
        ctx.scan("java");
        ctx.refresh();
        App app = (App) ctx.getBean("app");

        Client client = ctx.getBean(Client.class);
        System.out.println(client.toString());

        app.logEvent( EventType.INFO);

        ctx.close();
    }
}


