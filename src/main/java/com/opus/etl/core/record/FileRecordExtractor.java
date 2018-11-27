package com.opus.etl.core.record;

import java.io.IOException;

import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.field.FileFieldExtractor;
import com.opus.etl.core.field.IFieldExtractor;
import com.opus.etl.core.stream.IStream;

public class FileRecordExtractor implements IRecordExtractor {

	public String[] record;

	public String extractRecord(IStream stream, ConfigDTO config) throws IOException {

		String fileType = config.getSourceType();

		switch (fileType) {
		case "csv":
			extractCSV(stream, config);
			break;
		case "txt":
			extractFixedFormatFile(stream, config);
			break;
		case "xls":

			break;
		case "xlsx":

			break;
		case "db":

			break;
		default:
			break;
		}

		return null;
	}

	public void extractCSV(IStream stream, ConfigDTO config) throws IOException {
		String recordSeperator = config.getRecordSeperator();
		int headerLineNumber = Integer.parseInt(config.getHeaderRow());

		// Store stream object into temp stream

		// read each record using stream object
		System.out.println("***********DATA************");
		stream.streamData(config).skip(headerLineNumber).forEach((eachRecord) -> {

			record = eachRecord.toString().split(recordSeperator);

			IFieldExtractor fieldExtractor = new FileFieldExtractor();

			for (String line : record){
				System.out.println("-------- New Record  " + "---");

				fieldExtractor.extractFields(config, line);
			}

		});

	}

	public void extractFixedFormatFile(IStream stream, ConfigDTO config) throws IOException {
		Boolean headerPresent = true;
		int headerLineNumber = 0;
		int totalRecordLength = 81;

		// System.out.println(stream.streamData(config));
		stream.streamData(config).skip(headerLineNumber).forEach((eachRecord) -> {

			System.out.println(eachRecord);
			System.out.println(eachRecord.toString().length() + "-----------");

		});

	}

}
