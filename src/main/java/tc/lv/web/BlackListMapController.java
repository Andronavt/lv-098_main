package tc.lv.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlackListMapController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "secure_blackListMap", method = RequestMethod.GET)
    public String showMapBlackList() {
	return "secure_blackListMap";
    }

}
