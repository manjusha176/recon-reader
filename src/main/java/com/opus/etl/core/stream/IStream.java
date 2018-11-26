package com.opus.etl.core.stream;

import java.util.stream.Stream;

import com.opus.etl.core.dto.ConfigDTO;

public interface IStream {
	public Stream<?> streamData(ConfigDTO config);

}
