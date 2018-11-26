package com.opus.etl.core.config;

import org.json.JSONArray;
import org.json.JSONObject;

import com.opus.etl.core.dto.ConfigDTO;
import com.opus.etl.core.dto.Field;

public class FileConfig implements IConfig{

	public ConfigDTO loadConfig() {
		ConfigDTO config = new ConfigDTO();
		
		JSONObject obj = new JSONObject(Constants.jsonData);
		System.out.println(Constants.jsonData);
        String sourceType = obj.getJSONObject("source").getString("type");
        String sourcePath = obj.getJSONObject("source").getString("path");
        String fieldSeperator = obj.getJSONObject("fieldconf").getString("fieldsep");
        
        String isHeader = obj.getJSONObject("recordconf").getString("isheader");
        String headerRow = obj.getJSONObject("recordconf").getString("headerrow");
        String recordSeperator = obj.getJSONObject("recordconf").getString("recordsep");
        
        config.setSourceType(sourceType);
        config.setSourcePath(sourcePath);
        config.setFieldSeperator(fieldSeperator);
        config.setIsheader(isHeader.equals("true") ?true:false);
        config.setHeaderRow(headerRow);
        config.setRecordSeperator(recordSeperator);
        
        String fieldName = "";
        String fieldType = "";
        int fieldIndex = 0;
        System.out.println(sourceType+"==>"+sourcePath+"==>"+fieldSeperator+"==>"+isHeader+"==>"+headerRow+"==>"+recordSeperator);
        JSONArray arr = obj.getJSONArray("fields");
        for (int i = 0; i < arr.length(); i++) {
             fieldName = arr.getJSONObject(i).getString("name");
             fieldType = arr.getJSONObject(i).getString("datatype");
             fieldIndex = arr.getJSONObject(i).getInt("index");
             
             config.getFieldList().add(new Field(fieldName,fieldType,fieldIndex));
             
             System.out.println(fieldName+"==>"+fieldType+"==>"+fieldIndex);
             
             
            
        }
        System.out.println(config.getFieldList().size());
		System.out.println(config);
		
		return  config;
	}
	
//	public static void main(String[] args) {
//		FileConfig fc = new FileConfig();
//		ConfigDTO configdto = fc.loadConfig();
//		
//		System.out.println("Source Type :"+configdto.getSourceType());
//		System.out.println("Path :"+configdto.getSourcePath());
//		System.out.println("Field Seperator :"+configdto.getFieldSeperator());
//		System.out.println("isheader :"+configdto.isIsheader());
//		System.out.println("Header Row :"+configdto.getHeaderRow());
//		System.out.println("RecordSeperator :"+configdto.getRecordSeperator());
//		
//		for(Field field : configdto.getFieldList()) {
//			System.out.println(field.getFieldName() +"==>"+field.getFieldType()+"==>"+field.getFieldIndex());
//		}
//		
//		List fieldList = new ArrayList();
//		fieldList.add(new Field("eno","String",1));
//		fieldList.add(new Field("ename","String",2));
//		ConfigDTO config = new ConfigDTO("csv","d:\\yogesh",",",true,"1","\n",fieldList);
//		
//		System.out.println(config);
//		
//	}
	
	

}
