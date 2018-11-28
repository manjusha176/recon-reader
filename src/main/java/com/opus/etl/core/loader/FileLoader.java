package com.opus.etl.core.loader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
// test for pull req
import com.opus.etl.core.dto.ConfigDTO;

public class FileLoader implements ILoader {

	public Stream<?> streamData(ConfigDTO config) throws IOException {

		String fileName = config.getSourcePath();

		Stream<?> inputStream = null;

		inputStream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8);
		return inputStream;
	}

}
