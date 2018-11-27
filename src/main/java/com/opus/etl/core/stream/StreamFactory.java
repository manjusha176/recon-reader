package com.opus.etl.core.stream;

public class StreamFactory {

	public static IStream getStreamClass(String fileType) {
		
		if (fileType.equals("csv") ||fileType.equals("txt"))
			return new FileStream();
		else if (fileType.equals("db"))
			return new DBStream();
		else if (fileType.equals("xls"))
			return new XLSStream();

		return null;
	}

}
