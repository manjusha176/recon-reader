package com.opus.etl.core.record;

import java.util.stream.Stream;

import com.opus.etl.core.config.IConfig;
import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.stream.IStream;

public interface IRecordExtractor {
	public String extractecord(IStream inputStream,ConfigDTO config);

}
