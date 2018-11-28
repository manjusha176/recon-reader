package com.opus.etl.core.main;

import java.io.IOException;

import com.opus.etl.core.config.FileConfig;
import com.opus.etl.core.config.FlatFileConfig;
import com.opus.etl.core.config.IConfig;
import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.loader.ILoader;
import com.opus.etl.core.loader.LoaderFactory;
import com.opus.etl.core.record.FileRecordExtractor;
import com.opus.etl.core.record.IRecordExtractor;

public class ReconMain {

	public static void main(String[] args) {

		try {

			ReconMain obj = new ReconMain();

			// for delimiter file
			obj.testDelimeterFile();

			// for flat file
			obj.testFlatFile();

		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}

	}

	public void testDelimeterFile() throws IOException {
		IConfig fc = new FileConfig();
		ConfigDTO config = fc.loadConfig();

		// Stream with factory pattern
		ILoader iStream = LoaderFactory.getStreamClass(config.getSourceType());

		// Record Extractor
		IRecordExtractor recordExtractor = new FileRecordExtractor();

		recordExtractor.extractRecord(iStream, config);
	}

	public void testFlatFile() throws IOException {
		IConfig fc = new FlatFileConfig();
		ConfigDTO config = fc.loadConfig();

		// Stream with factory pattern
		ILoader iStream = LoaderFactory.getStreamClass(config.getSourceType());

		// Record Extractor
		IRecordExtractor recordExtractor = new FileRecordExtractor();

		recordExtractor.extractRecord(iStream, config);
	}

}
