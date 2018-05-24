package client;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Client {
    private int id;
    private String fullName;

    public Client(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

}
