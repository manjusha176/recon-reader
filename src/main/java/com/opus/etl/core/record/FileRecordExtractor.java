package com.opus.etl.core.record;

import java.util.stream.Stream;

import com.opus.etl.core.config.FileConfig;
import com.opus.etl.core.config.IConfig;
import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.stream.IStream;

public class FileRecordExtractor implements IRecordExtractor {

	public String[] record;

	public String extractecord(IStream stream, ConfigDTO config) {

		String recordeSeperator = config.getRecordSeperator();
		int headerLineNumber = Integer.parseInt(config.getHeaderRow());

		// Strore stream object into temp stream
		Stream inputStream = stream.streamData(config);

		// read each record using stream object
		inputStream.skip(headerLineNumber).forEach((i) -> {

			// System.out.println(i);

			record = i.toString().split(recordeSeperator);

			for (String line : record){
				System.out.println("--- line: " + line);
			}

		});

		return null;
	}

}
