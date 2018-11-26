package com.opus.etl.core.field;

import java.util.Set;

import com.opus.etl.core.config.IConfig;

public interface IFieldExtractor {
	public Set<String> extractFields(IConfig config,String record);
}
