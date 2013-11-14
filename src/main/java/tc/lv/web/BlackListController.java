package tc.lv.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tc.lv.exceptions.BlackListServiceException;
import tc.lv.service.BlackListService;
import tc.lv.utils.ExceptionUtil;
import tc.lv.utils.IpValidator;

public class BlackListController {

    @Autowired
    private BlackListService blService;

    // Delete IP-address from BlackList
    @RequestMapping(value = "/deleteIpFromBL", method = RequestMethod.GET)
    public String deleteFromBL() {
	return "deleteIpFromBL";
    }

    // Delete IP-address from BlackList
    @RequestMapping(value = "/deleteIpFromBL", method = RequestMethod.POST)
    public String deleteFromBL(@ModelAttribute("address") String ipAddress,
	    Map<String, Object> map) {

	try {
	    if (IpValidator.isIpV4(ipAddress)) {
		blService.deleteIpV4(ipAddress);
		map.put("successMsg", "IpV4: " + ipAddress
			+ " has been successfully deleted.");
		return "result";
	    } else if (IpValidator.isIpV6(ipAddress)) {
		blService.deleteIpV6(ipAddress);
		map.put("successMsg", "IpV6: " + ipAddress
			+ " has been successfully deleted.");
		return "result";
	    } else {
		map.put("incorrectMsg", "Incorrect IP-address!");
		return "result";
	    }
	} catch (BlackListServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}
    }

    // Add IP-address from BlackList
    @RequestMapping(value = "/addIpToBL", method = RequestMethod.GET)
    public String addToBl() {
	return "addIpToBL";
    }

    // Add IP-address from BlackList
    @RequestMapping(value = "/addIpToBL", method = RequestMethod.POST)
    public @ResponseBody
    String addToBl(@ModelAttribute("address") String ipAddress,
	    Map<String, Object> map) {

	try {
	    if (IpValidator.isIpV4(ipAddress)) {
		blService.saveIpV4(ipAddress);
		map.put("successMsg", "IpV4: " + ipAddress
			+ " has been successfully added to BlackList.");
		return "result";
	    } else if (IpValidator.isIpV6(ipAddress)) {
		blService.saveIpV6(ipAddress);
		map.put("successMsg", "IpV6: " + ipAddress
			+ " has been successfully added to BlackList.");
		return "result";
	    } else {
		map.put("incorrectMsg", "Incorrect IP-address!");
		return "result";
	    }
	} catch (BlackListServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}

    }

    // Add IP-address from BlackList
    @RequestMapping(value = "/showIpListFromBL", method = RequestMethod.GET)
    public String showIpListFromBl() {
	return "showIpListFromBL";
    }

    // Add IP-address from BlackList
    @RequestMapping(value = "/showIpListFromBL", method = RequestMethod.POST)
    public String showIpListFromBl(Map<String, Object> map) {
	try {
	    map.put("ipList", blService.loadIpV4List());
	    return "showIpListFromBL"; // Need create alone jsp-page
	} catch (BlackListServiceException e) {
	    map.put("errorList", ExceptionUtil.createErrorList(e));
	    map.put("errorMsg", e.getMessage());
	    return "result";
	}
    }
}
