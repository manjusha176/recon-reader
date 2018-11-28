package com.opus.etl.core.stream;

public class StreamFactory {

	public static IStream getStreamClass(String fileType) {
		
		if (fileType.equalsIgnoreCase("csv") ||fileType.equalsIgnoreCase("txt"))
			return new FileStream();
		else if (fileType.equalsIgnoreCase("db"))
			return new DBStream();
		else if (fileType.equalsIgnoreCase("xls"))
			return new XLSStream();

		return null;
	}

}
