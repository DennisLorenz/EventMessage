package se.animatedgames;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Dennis Lorenz
 */
@Controller
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(final ModelMap model) {
        model.addAttribute("authenticated", true);
    }

//
//    @RequestMapping(method = POST, value = "/login")
//    @ResponseStatus(OK)
//    public CasinoLoginDto login(@CurrentPlayer final PlayerUser currentPlayer) {
//        final PlayerLogon playerLogon = playerService.logonPlayer(currentPlayer.getId(), ipAddress, authToken);
//        auditService.trackPlayerActivityWithIpAddress(playerLogon.getPlayer(), PlayerActivityType.LOGIN, IpAddressUtils.extract(ipAddress));
//        return new CasinoLoginDto(playerLogon);
//    }
}
