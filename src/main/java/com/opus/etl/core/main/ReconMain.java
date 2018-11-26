package com.opus.etl.core.main;

import java.io.IOException;

import com.opus.etl.core.config.FileConfig;
import com.opus.etl.core.config.IConfig;
import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.record.FileRecordExtractor;
import com.opus.etl.core.record.IRecordExtractor;
import com.opus.etl.core.stream.IStream;
import com.opus.etl.core.stream.StreamFactory;

public class ReconMain {

	public static void main(String[] args) {
		
		try {
			//configuration 
			IConfig fc = new FileConfig();
			ConfigDTO config = fc.loadConfig();

			//Stream with factory pattern
			IStream iStream = StreamFactory.getStreamClass(config.getSourceType());
			//Stream inputStream = iStream.streamData(config);
			
			//Record Extractor
			IRecordExtractor recordExtractor = new FileRecordExtractor();
			
			
			String record = recordExtractor.extractecord(iStream, config);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error: "+e.toString());
			}
			

		}



	}


