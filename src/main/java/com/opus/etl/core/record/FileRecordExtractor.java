package com.opus.etl.core.record;

import java.io.IOException;

import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.field.FileFieldExtractor;
import com.opus.etl.core.field.IFieldExtractor;
import com.opus.etl.core.stream.IStream;

public class FileRecordExtractor implements IRecordExtractor {

	public String[] record;

	public String extractecord(IStream stream, ConfigDTO config) throws IOException {

		String recordeSeperator = config.getRecordSeperator();
		int headerLineNumber = Integer.parseInt(config.getHeaderRow());

		// Store stream object into temp stream

		// read each record using stream object
		System.out.println("***********DATA************");
		stream.streamData(config).skip(headerLineNumber).forEach((i) -> {

			record = i.toString().split(recordeSeperator);

			IFieldExtractor fieldExtractor = new FileFieldExtractor();

			for (String line : record){
				System.out.println("-------- New Record  " +"---" );

				fieldExtractor.extractFields(config, line);
			}

		});

		return null;
	}

}
