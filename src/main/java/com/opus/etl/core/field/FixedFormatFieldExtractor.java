package com.opus.etl.core.field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.dto.Field;

public class FixedFormatFieldExtractor implements IFieldExtractor {

	public Map<Integer, Map<String, String>> extractFields(ConfigDTO config, String line) {
		String field;
		List<String> fieldList = new ArrayList<>();
		List<Field> configHeader = config.getFieldList();
		int beginIndex = 0;
		int lastIndex;

		for (Field header : configHeader){
			try{
				lastIndex = header.getFieldSize();
				lastIndex = beginIndex + lastIndex;
				field = line.substring(beginIndex, lastIndex);
				beginIndex = lastIndex;

				fieldList.add(field);
			} catch (Exception e){
				System.out.println("File is not formatted according to configuration");
				e.printStackTrace();
			}
		}

		//System.out.println(fieldList);
		FileFieldExtractor fieldExtractor = new FileFieldExtractor();

		Map<String, String> fieldMap = fieldExtractor.getFieldMap(fieldExtractor.getHeaderList(config), fieldList);
		System.out.println(fieldMap);
		
		Map<Integer, Map<String, String>> finalMap = new HashMap<>();
		finalMap.put(0, fieldMap);

		return finalMap;
		

	}

	
}
