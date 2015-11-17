package se.animatedgames;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm() {
        return "form";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String checkMessageInfo(@Valid Message message, BindingResult bindingResult) throws Exception {
        System.out.println("from WebController " + message);

        rabbitTemplate.convertAndSend(Constants.messageQueue, message);

        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "form";
    }
}
