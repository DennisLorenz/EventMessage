package se.animatedgames;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Dennis Lorenz
 */
@Service
@RabbitListener(queues = Constants.messageQueue)
public class CasinoService {

    private final SimpMessagingTemplate template;

    @Autowired
    public CasinoService(SimpMessagingTemplate template) {
        this.template = template;
    }

    @RabbitHandler
    public void receiveMessage(@Payload Message message) {
        System.out.println("from CasinoService " + message);
        if (!message.getUser().isEmpty()) {
            template.convertAndSendToUser(message.getUser(), "/queue/big.wins", new AuthenticatedUserMessage(message));
        } else {
            template.convertAndSend("/topic/greetings", new AllUsersMessage(message));
        }
    }

}
