package event.loger;

import event.Event;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
@Component("fileLoger")
public class FileEventLoger implements EventLoger {

    @Value("${fileName}")
    private String fileName;
    private File file;


    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(file, event.toString(), (String) null);
    }

    @PostConstruct
    public void init() throws IOException{
        FileUtils.touch(file = new File("src/main/resources/"+fileName));
        if(!file.canWrite()) throw new IOException("Can't write to " + fileName);
    }
}
