package event.loger;

import event.Event;
import lombok.Setter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLoger implements EventLoger {
    @Setter
    private String fileName;
    private File file;


    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(file, event.toString(), (String) null);
    }
    public void init() throws IOException{
        FileUtils.touch(file = new File("src/main/resources/"+fileName));
        if(!file.canWrite()) throw new IOException("Can't write to " + fileName);
    }
}
