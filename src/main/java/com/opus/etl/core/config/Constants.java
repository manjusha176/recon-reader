package com.opus.etl.core.config;

public class Constants {
public static final String jsonData = "{\"source\": {\r\n" + 
		"          \"type\": \"txt\",\r\n" + 
		"          \"path\": \"d:\\\\Recon\\\\input.txt\"\r\n" + 
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

public static final String jsonData1 = "{\"source\": {\r\n" + 
				"          \"type\": \"txt\",\r\n" + 
				"          \"path\": \"d:\\\\Recon\\\\input.txt\"\r\n" + 
				"        },\r\n" + 
				"        \"fieldconf\": {\r\n" + 
				"          \"fieldsep\": \",\"\r\n" + 
				"        },\r\n" + 
				"        \"recordconf\": {\r\n" + 
				"          \"isheader\": \"true\",\r\n" + 
				"          \"headerrow\": \"1\",\r\n" + 
				"          \"recordsep\": \"\\n\"\r\n" + 
				"        },\r\n" + 
				"        \"fields\":[{\"name\" :\"Year\",\r\n" + 
				"                  \"datatype\" : \"int\",\r\n" + 
				"                  \"index\" : 0},\r\n" + 
				"                  {\"name\" :\"Industry_aggregation_NZSIOC\",\r\n" + 
				"                  \"datatype\" : \"String\",\r\n" + 
				"                  \"index\" : 1},\r\n" + 
				"                  {\"name\" :\"Industry_code_NZSIOC\",\r\n" + 
				"                  \"datatype\" : \"String\",\r\n" + 
				"                  \"index\" : 2},\r\n" + 
				"                  {\"name\" :\"Industry_name_NZSIOC\",\r\n" + 
				"                  \"datatype\" : \"String\",\r\n" + 
				"                  \"index\" : 3},\r\n" + 
				"                   {\"name\" :\"Units\",\r\n" + 
				"                  \"datatype\" : \"String\",\r\n" + 
				"                  \"index\" : 4},\r\n" + 
				"                  {\"name\" :\"Variable_code\",\r\n" + 
				"                  \"datatype\" : \"String\",\r\n" + 
				"                  \"index\" : 5},\r\n" + 
				"                  {\"name\" :\"Variable_name\",\r\n" + 
				"                  \"datatype\" : \"String\",\r\n" + 
				"                  \"index\" : 6},\r\n" + 
				"                  {\"name\" :\"Variable_category\",\r\n" + 
				"                  \"datatype\" : \"String\",\r\n" + 
				"                  \"index\" : 7},\r\n" + 
				"                  {\"name\" :\"Value\",\r\n" + 
				"                  \"datatype\" : \"String\",\r\n" + 
				"                  \"index\" : 8},\r\n" + 
				"                  {\"name\" :\"Industry_code_ANZSIC06\",\r\n" + 
				"                  \"datatype\" : \"String\",\r\n" + 
				"                  \"index\" : 9}\r\n" + 
				"                  ]\r\n" + 
				"}";

// For flat file
public static final String jsonDataflat = "{\"source\": {\r\n" + 
	       "          \"type\": \"txt\",\r\n" + 
	       "          \"path\": \"d:\\\\Recon\\\\sample.txt\"\r\n" + 
	       "        },\r\n" + 
	       "        \"fieldconf\": {\r\n" + 
	       "          \"field sep\": \",  or ;\"\r\n" + 
	       "        },\r\n" + 
	       "        \"record conf\": {\r\n" + 
	       "          \"isHeader\": \"true\",\r\n" + 
	       "          \"headerRow\": \"1\",\r\n" + 
	       "          \"newRecord\": \"\\n\"\r\n" + 
	       "        },\r\n" + 
	       "        \"fields\":[{\"name\" :\"id\",\r\n" + 
	       "                  \"datatype\" : \"int\",\r\n" + 
	       "                  \"index\" : 0,\r\n" + 
	       "                  \"size\":2\r\n" + 
	       "        },\r\n" + 
	       "                  {\"name\" :\"name\",\r\n" + 
	       "                  \"datatype\" : \"String\",\r\n" + 
	       "                  \"index\" : 2,\r\n" + 
	       "                  \"size\":20},\r\n" + 
	       "                  {\"name\" :\"amount\",\r\n" + 
	       "                  \"datatype\" : \"int\",\r\n" + 
	       "                  \"index\" : 2,\r\n" + 
	       "                  \"size\":8\r\n" + 
	       "                  },\r\n" + 
	       "                  {\"name\" :\"remark\",\r\n" + 
	       "                  \"datatype\" : \"String\",\r\n" + 
	       "                  \"index\" : 2,\r\n" + 
	       "                  \"size\":45\r\n" + 
	       "                  }\r\n" + 
	       "                  ]\r\n" + 
	       "          \r\n" + 
	       "        \r\n" + 
	       "}";

}
