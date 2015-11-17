package se.animatedgames;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dennis Lorenz
 */
public class AllUsersMessage {

    @JsonProperty
    private final String text;

    public AllUsersMessage(final Message message) {
        text = message.getInput();

        System.out.println("From AllUsersMessage " + text);
    }
}
