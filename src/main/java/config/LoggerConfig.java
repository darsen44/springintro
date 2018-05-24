package config;

import event.loger.EventLoger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@PropertySource("classpath:client.properties")
public class LoggerConfig {

    @Autowired
    @Qualifier("console")
    private EventLoger consoleEventLoger;

    @Autowired
    @Qualifier("fileLoger")
    private EventLoger fileEventLoger;

    @Autowired
    @Qualifier("cache")
    private EventLoger cacheFileEventLoger;

    @Bean
    public Collection<EventLoger> combinedLoggers() {
        Collection<EventLoger> loggers = new ArrayList<EventLoger>(2);
        loggers.add(consoleEventLoger);
        loggers.add(fileEventLoger);
        return loggers;
    }


}
