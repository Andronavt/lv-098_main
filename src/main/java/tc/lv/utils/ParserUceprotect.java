package tc.lv.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;
import tc.lv.exceptions.DownloadException;

public class ParserUceprotect implements Parser {

    protected static final String IP_ALL = "(([0-9]{0,3}+[.]){3}+([0-9]{1,}){1})|(([0-9a-zA-Z]{4}+[:]){2}+[0-9a-zA-Z]{0,4})";

    private static final Logger LOGGER = Logger
	    .getLogger(ParserUceprotect.class);
    private static final Pattern PATTERN = Pattern.compile(IP_ALL);

    private ParserResults parserResults;

    public ParserUceprotect() {
	parserResults = new ParserResults();
    }

    @Override
    public ParserResults parse(File file) throws DownloadException {
	LOGGER.info("START PARSING Uceprotect");

	Matcher matcher;
	Scanner scanner;

	try {
	    scanner = new Scanner(new BufferedReader(new FileReader(file)));

	    while (scanner.hasNext()) {
		String ipStr = "";
		matcher = PATTERN.matcher(scanner.nextLine());

		if (matcher.find()) {
		    ipStr = matcher.group();

		    if (IpValidator.isIpV4(ipStr)) {
			parserResults.ipV4List.add(new IpV4Address(ipStr,
				new Date()));
		    } else if (IpValidator.isIpV6(ipStr)) {
			parserResults.ipV6List.add(new IpV6Address(ipStr,
				new Date()));
		    } else {
			parserResults.notValidList.add(new NotValidIp(ipStr,
				new Date()));
		    }
		}
	    }
	    scanner.close();

	} catch (Exception e) {
	    LOGGER.error("File not found!", e);
	    throw new DownloadException("File not found", e);
	}
	LOGGER.info("FINISH PARSING Uceprotect");
	return parserResults;
    }

}
