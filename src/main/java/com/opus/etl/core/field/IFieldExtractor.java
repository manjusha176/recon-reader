package com.opus.etl.core.field;

import java.util.Map;

import com.opus.etl.core.config.IConfig;
import com.opus.etl.core.dto.ConfigDTO;

public interface IFieldExtractor {
	public Map<Integer, Map<String, String>> extractFields(ConfigDTO config,String record);
}
