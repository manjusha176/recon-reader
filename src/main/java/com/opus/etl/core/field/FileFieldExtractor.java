package com.opus.etl.core.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.dto.Field;

public class FileFieldExtractor implements IFieldExtractor {
	private static final char DEFAULT_QUOTE = '"';

	public Map<Integer, Map<String, String>> extractFields(ConfigDTO config, String record) {
		int countDelimiter = 0;

		List<String> headerList = new ArrayList<>(); /// getting header list from config
		for (Field fieldProperty : config.getFieldList()){
			headerList.add(fieldProperty.getFieldName());
		}

		String delimiter = config.getFieldSeperator();
		char[] delimiterChar = delimiter.toCharArray();

		for (int i = 0; i < record.length(); i++){
			if (record.charAt(i) == delimiterChar[0]){
				countDelimiter++;
			}
		}

		List<String> fieldList = new ArrayList<>(Arrays.asList(record.split(delimiter)));

		if (countDelimiter != headerList.size() - 1){

			System.out.println("Special case");
			CSVFieldValidator csvValidator = new CSVFieldValidator();
			fieldList = csvValidator.parseLine(record, delimiterChar[0], DEFAULT_QUOTE);

		}

		// set header and value in map
		Map<String, String> fieldMap = new HashMap<>();
		int i = 0;
		for (String field : fieldList){
			fieldMap.put(headerList.get(i), field);
			i++;
		}

		// iterating map of key/value
		Iterator<Map.Entry<String, String>> entries = fieldMap.entrySet().iterator();

		while (entries.hasNext()){
			Map.Entry<String, String> entry = entries.next();
			System.out.println("Key = " + entry.getKey() + ", \t Value = " + entry.getValue());

		}

		Map<Integer, Map<String, String>> finalMap = new HashMap<>();
		finalMap.put(0, fieldMap);

		return finalMap;

	}

}
