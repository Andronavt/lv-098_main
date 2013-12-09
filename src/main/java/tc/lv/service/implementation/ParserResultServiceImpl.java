package tc.lv.service.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;
import tc.lv.exceptions.ParserResultServiceException;
import tc.lv.service.IpAddressService;
import tc.lv.service.ParserResultService;
import tc.lv.utils.ParserResults;

@Service
public class ParserResultServiceImpl implements ParserResultService {

    private static final Logger LOGGER = Logger
	    .getLogger(ParserResultServiceImpl.class);

    @Autowired
    private IpAddressService ipAddressService;

    // Update source in DataBAse
    @Override
    @Transactional
    public void save(ParserResults result) throws ParserResultServiceException {

	try {
	    LOGGER.info("Start updating Data Base");

	    LOGGER.info("Start update IpV4List");
	    ipAddressService.saveList(result.getIpV4List(),
		    result.getSourceId(), IpV4Address.class, IpAddress.IP_MAP);
	    LOGGER.info("Finish updating IpV4List");

	    LOGGER.info("Start update IpV6List");
	    ipAddressService.saveList(result.getIpV6List(),
		    result.getSourceId(), IpV6Address.class, IpAddress.IP_MAP);
	    LOGGER.info("Finish updating IpV6List");

	    LOGGER.info("Start update NotValidList");
	    ipAddressService.saveList(result.getNotValidList(),
		    result.getSourceId(), NotValidIp.class, IpAddress.IP_MAP);
	    LOGGER.info("Finish updating NotValidList");

	    LOGGER.info("Finish updating Data Base");
	} catch (Exception e) {
	    LOGGER.error(e);
	    throw new ParserResultServiceException(
		    "Could not save IP List to Data Base", e);
	}
    }

}
