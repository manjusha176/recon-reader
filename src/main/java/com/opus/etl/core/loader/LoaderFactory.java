package com.opus.etl.core.loader;

public class LoaderFactory {

	public static ILoader getStreamClass(String fileType) {
		
		if (fileType.equalsIgnoreCase("csv") ||fileType.equalsIgnoreCase("txt"))
			return new FileLoader();
		else if (fileType.equalsIgnoreCase("db"))
			return new DBLoader();
		else if (fileType.equalsIgnoreCase("xls"))
			return new XLSLoader();

		return null;
	}

}
