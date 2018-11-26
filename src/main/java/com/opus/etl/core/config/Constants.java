package com.opus.etl.core.config;

public class Constants {
public static final String jsonData = "{\"source\": {\r\n" + 
		"          \"type\": \"csv\",\r\n" + 
		"          \"path\": \"d:\\\\Recon\\\\input.csv\"\r\n" + 
		"        },\r\n" + 
		"        \"fieldconf\": {\r\n" + 
		"          \"fieldsep\": \",\"\r\n" + 
		"        },\r\n" + 
		"        \"recordconf\": {\r\n" + 
		"          \"isheader\": \"true\",\r\n" + 
		"          \"headerrow\": \"1\",\r\n" + 
		"          \"recordsep\": \"\\n\"\r\n" + 
		"        },\r\n" + 
		"        \"fields\":[{\"name\" :\"eno\",\r\n" + 
		"                  \"datatype\" : \"int\",\r\n" + 
		"                  \"index\" : 0},\r\n" + 
		"                  {\"name\" :\"ename\",\r\n" + 
		"                  \"datatype\" : \"String\",\r\n" + 
		"                  \"index\" : 1}\r\n" + 
		"                  ]\r\n" + 
		"          \r\n" + 
		"        \r\n" + 
		"}";
}
