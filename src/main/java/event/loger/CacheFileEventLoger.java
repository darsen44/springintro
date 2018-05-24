package event.loger;

import event.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component("cache")
public class CacheFileEventLoger extends FileEventLoger {
    @Value("${cacheSize}")
    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileEventLoger(int cacheSize) {
        this.cacheSize = cacheSize;
    }
    public void logEvent(Event event) throws IOException {
        cache.add(event);
        if(cache.size() == cacheSize){
            cache.clear();
        }
    }

    public void writeEventsFromCache() throws IOException {
        for (int i = 0; i < cache.size(); i++) {
            super.logEvent(cache.get(i));
        }
    }
    @PreDestroy
    public void destroy() throws IOException {
        if(!cache.isEmpty()) writeEventsFromCache() ;
    }
}
