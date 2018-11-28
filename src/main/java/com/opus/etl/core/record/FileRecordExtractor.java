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

		if (fileType.equalsIgnoreCase("csv"))
			extractCSV(stream, config);
		else if (fileType.equalsIgnoreCase("txt")) extractFixedFormatFile(stream, config);

		return null;
	}

	// Extract CSV file
	public void extractCSV(IStream stream, ConfigDTO config) throws IOException {

		String recordSeperator = config.getRecordSeperator();
		int headerLineNumber = Integer.parseInt(config.getHeaderRow());

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

	// Extract Fixed Format File
	public void extractFixedFormatFile(IStream stream, ConfigDTO config) throws IOException {

		int headerLineNumber = Integer.parseInt(config.getHeaderRow());
		int totalRecordLength = Integer.parseInt(config.getTotalSize());

		stream.streamData(config).skip(headerLineNumber).forEach((eachRecord) -> {

			// record = eachRecord.toString().split("(?<=\\G.{81})");
			record = eachRecord.toString().split("(?<=\\G.{" + totalRecordLength + "})");

			for (String line : record){
				System.out.println("--------Record length -> " + line.length() + ":::: record ->" + line);

			}

		});

	}

}
