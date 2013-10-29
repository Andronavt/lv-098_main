package tc.lv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String index() {
	return "index";
    }
    @RequestMapping(value = "/testCSS")
    public String test() {
	return "testCSS";
    }

}