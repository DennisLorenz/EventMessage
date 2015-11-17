package se.animatedgames;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dennis Lorenz
 */
public class AuthenticatedUserMessage {

    @JsonProperty
    private final String text;

    public AuthenticatedUserMessage(final Message message) {
        text = message.getInput();

        System.out.println("From AuthenticatedUsersMessage " + text);
    }
}
