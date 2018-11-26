package com.opus.etl.core.record;

import com.opus.etl.core.config.FileConfig;
import com.opus.etl.core.config.IConfig;
import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.stream.FileStream;
import com.opus.etl.core.stream.IStream;

public class Sample {
	public static void main(String[] args) {
		
		//config
		IConfig fc = new FileConfig();
		ConfigDTO config = fc.loadConfig();

		//Stream
		IStream iStream = new FileStream();
		//Stream inputStream = iStream.streamData(config);
		
		//Record Extractor
		IRecordExtractor recordExtractor = new FileRecordExtractor();
		
		String record = recordExtractor.extractecord(iStream, config);
		
		
		

	}
}
