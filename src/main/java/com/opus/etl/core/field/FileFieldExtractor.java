package com.opus.etl.core.field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.dto.Field;

public class FileFieldExtractor implements IFieldExtractor {

	public Map<Integer, Map<String, String>> extractFields(ConfigDTO config, String record) {

		List<String> headerList = getHeaderList(config);

		String delimiter = config.getFieldSeperator();
		char[] delimiterChar = delimiter.toCharArray(); //TODO convert delimiter datatype from String to char

		ArrayList<String> words = new ArrayList<>();
		boolean notInsideComma = true;
		int start = 0;
		for (int i = 0; i < record.length() - 1; i++){
			if (record.charAt(i) == delimiterChar[0] && notInsideComma){
				words.add(record.substring(start, i));
				start = i + 1;
			} else if (record.charAt(i) == '"') notInsideComma = !notInsideComma;
		}

		words.add(record.substring(start));
		System.out.println(record + "---->" + words);

		// set header and value in map
		Map<String, String> fieldMap = getFieldMap(headerList, words);

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

	public Map<String, String> getFieldMap(List<String> headerList, List<String> fieldList) {
		Map<String, String> fieldMap = new HashMap<>();
		int i = 0;
		for (String field : fieldList){
			fieldMap.put(headerList.get(i), field);
			i++;
		}
		return fieldMap;
	}

	public List<String> getHeaderList(ConfigDTO config) {
		List<String> headerList = new ArrayList<>(); /// getting header list from config
		for (Field fieldProperty : config.getFieldList()){
			headerList.add(fieldProperty.getFieldName());
		}
		return headerList;
	}

	public static void main(String args[]) {
		FileFieldExtractor validator = new FileFieldExtractor();
		ConfigDTO c1 = new ConfigDTO();
		c1.setFieldSeperator(",");
		List<Field> fieldList = new ArrayList<>();
		Field f1 = new Field("id", "Type", 3, 4);
		Field f2 = new Field("Name", "Type", 3, 4);
		Field f3 = new Field("Address", "Type", 3, 4);
		Field f4 = new Field("Amount", "Type", 3, 4);
		fieldList.add(f1);
		fieldList.add(f2);
		fieldList.add(f3);
		fieldList.add(f4);
		c1.setFieldList(fieldList);
		validator.extractFields(c1, "\"1\",\"US\",\"United States\"");
		validator.extractFields(c1, "\"aaa\",\"b,bb\",\"ccc\"");
		validator.extractFields(c1, "\"aaa\",\"b\"\"bb\",\"ccc\"");
		validator.extractFields(c1, "\"aaa\",\"b\"\"bb\",\"ccc\"");
		validator.extractFields(c1, "11,AU,Aus\"\"tralia");

	}
}
