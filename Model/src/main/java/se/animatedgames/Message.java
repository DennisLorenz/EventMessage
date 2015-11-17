package se.animatedgames;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 2, max = 30)
    private String input;

    @Size(min = 2, max = 30)
    private String user;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String toString() {
        return "Message(Input: " + input + ", user: " + user + ")";
    }
}
