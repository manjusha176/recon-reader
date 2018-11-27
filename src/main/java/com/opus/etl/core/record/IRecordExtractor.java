package com.opus.etl.core.record;

import java.io.IOException;

import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.stream.IStream;

public interface IRecordExtractor {
	public String extractRecord(IStream inputStream,ConfigDTO config) throws IOException;

}
