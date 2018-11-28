package com.opus.etl.core.record;

import java.io.IOException;

import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.field.FileFieldExtractor;
import com.opus.etl.core.field.FixedFormatFieldExtractor;
import com.opus.etl.core.field.IFieldExtractor;
import com.opus.etl.core.loader.ILoader;

public class FileRecordExtractor implements IRecordExtractor {

	public String[] record;

	public String extractRecord(ILoader loader, ConfigDTO config) throws IOException {

		String fileType = config.getSourceType();

		if (fileType.equalsIgnoreCase("csv"))
			extractCSV(loader, config);
		else if (fileType.equalsIgnoreCase("txt")) extractFixedFormatFile(loader, config);

		return null;
	}

	// Extract CSV file
	public void extractCSV(ILoader loader, ConfigDTO config) throws IOException {

		String recordSeperator = config.getRecordSeperator();
		int headerLineNumber = Integer.parseInt(config.getHeaderRow());

		// read each record using stream object
		System.out.println("***********DATA************");
		loader.streamData(config).skip(headerLineNumber).forEach((eachRecord) -> {

			record = eachRecord.toString().split(recordSeperator);

			IFieldExtractor fieldExtractor = new FileFieldExtractor();

			for (String line : record){
				System.out.println("-------- New Record  " + "---");

				fieldExtractor.extractFields(config, line);
			}

		});

	}

	// Extract Fixed Format File
	public void extractFixedFormatFile(ILoader loader, ConfigDTO config) throws IOException {

		int headerLineNumber = Integer.parseInt(config.getHeaderRow());
		int totalRecordLength = Integer.parseInt(config.getTotalSize());
		IFieldExtractor fixedFieldExtractor = new FixedFormatFieldExtractor();

		loader.streamData(config).skip(headerLineNumber).forEach((eachRecord) -> {

			// record = eachRecord.toString().split("(?<=\\G.{81})");
			record = eachRecord.toString().split("(?<=\\G.{" + totalRecordLength + "})");

			for (String line : record){
				fixedFieldExtractor.extractFields(config, line);
			//	System.out.println("--------Record length -> " + line.length() + ":::: record ->" + line);

			}

		});

	}

}
