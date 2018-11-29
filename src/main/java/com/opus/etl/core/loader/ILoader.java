package com.opus.etl.core.loader;

import java.io.IOException;
import java.util.stream.Stream;

import com.opus.etl.core.dto.ConfigDTO;

@FunctionalInterface
public interface ILoader {
	public Stream<?> streamData(ConfigDTO config) throws IOException;

}
