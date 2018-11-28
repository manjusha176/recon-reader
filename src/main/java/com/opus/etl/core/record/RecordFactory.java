package com.opus.etl.core.record;

public class RecordFactory {

public static IRecordExtractor getRecordExtractorClass(String fileType) {
		
		if (fileType.equalsIgnoreCase("csv") ||fileType.equalsIgnoreCase("txt"))
			return new FileRecordExtractor();
		else if (fileType.equalsIgnoreCase("db"))
			return new DBRecordExtractor();
		else if (fileType.equalsIgnoreCase("xls"))
			return new XLSRecordExtractor();

		return null;
	}
}
