package com.opus.etl.core.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
// test for pull req
import com.opus.etl.core.dto.ConfigDTO;

public class FileStream implements IStream {

	public Stream<?> streamData(ConfigDTO config) {
		
		String fileName = config.getSourcePath(); // this path is on my local

		Stream<?> inputStream = null;
		try {
			inputStream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8);
			return inputStream;

		} catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

}
