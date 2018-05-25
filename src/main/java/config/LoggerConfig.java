package config;

import event.EventType;
import event.loger.EventLoger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:client.property")
public class LoggerConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    @Qualifier("console")
    private EventLoger consoleEventLoger;

    @Autowired
    @Qualifier("fileLoger")
    private EventLoger fileEventLoger;

    @Autowired
    @Qualifier("cache")
    private EventLoger cacheFileEventLoger;

    @Autowired
    @Qualifier("combine")
    private EventLoger combineEventLoger;

    @Bean
    public Collection<EventLoger> combinedLoggers() {
        Collection<EventLoger> loggers = new ArrayList<EventLoger>(2);
        loggers.add(consoleEventLoger);
        loggers.add(fileEventLoger);
        return loggers;
    }

    @Bean
    public Map<EventType, EventLoger> loggerMap() {
        Map<EventType, EventLoger> map = new HashMap<>();
        map.put(EventType.INFO, consoleEventLoger);
        map.put(EventType.ERROR, combineEventLoger);
        return map;
    }

}
