package tc.lv.service;

import java.util.List;
import java.util.Map;

import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;
import tc.lv.exceptions.GeoIpException;
import tc.lv.exceptions.IpAddressServiceException;

public interface IpAddressService {

    public boolean saveIpByStatus(String address, String status)
	    throws IpAddressServiceException;

    public boolean deleteIpByAddress(String address)
	    throws IpAddressServiceException;

    public void saveList(List<? extends IpAddress> list, int sourceId,
	    Class<? extends IpAddress> ipType, Map<String, IpAddress> map)
	    throws IpAddressServiceException;

    public void updateStatusList(Map<String, IpAddress> map)
	    throws IpAddressServiceException;

    public void createAllMaps();

    public boolean procesingIpAddress(IpAddress ip, Source source)
	    throws GeoIpException, IpAddressServiceException;

}
