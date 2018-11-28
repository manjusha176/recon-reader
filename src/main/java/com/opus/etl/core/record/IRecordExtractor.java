package com.opus.etl.core.record;

import java.io.IOException;

import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.loader.ILoader;

public interface IRecordExtractor {
	public String extractRecord(ILoader inputStream,ConfigDTO config) throws IOException;

}
