package com.opus.etl.core.field;

import java.util.Set;

import com.opus.etl.core.config.IConfig;

import org.json.JSONArray;
import org.json.JSONObject;

public class DBFieldExtractor implements IFieldExtractor{

	public Set<String> extractFields(IConfig config, String record) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	    public static void main(String[] args) {
	    	String json = "{\"source\": {\r\n" + 
	    			"          \"type\": \"csv\",\r\n" + 
	    			"          \"path\": \"d:\\\\yogeshyogesh\"\r\n" + 
	    			"        },\r\n" + 
	    			"        \"fieldconf\": {\r\n" + 
	    			"          \"field sep\": \",  or ;\"\r\n" + 
	    			"        },\r\n" + 
	    			"        \"record conf\": {\r\n" + 
	    			"          \"isHeader\": \"true\",\r\n" + 
	    			"          \"headerRow\": \"1\",\r\n" + 
	    			"          \"newRecord\": \"\\n\"\r\n" + 
	    			"        },\r\n" + 
	    			"        \"fields\":[{\"name\" :\"eno\",\r\n" + 
	    			"                  \"datatype\" : \"int\",\r\n" + 
	    			"                  \"index\" : 0},\r\n" + 
	    			"                  {\"name\" :\"ename\",\r\n" + 
	    			"                  \"datatype\" : \"String\",\r\n" + 
	    			"                  \"index\" : 2}\r\n" + 
	    			"                  ]\r\n" + 
	    			"          \r\n" + 
	    			"        \r\n" + 
	    			"}";
	        JSONObject obj = new JSONObject(json);
	        String pageName = obj.getJSONObject("source").getString("type");

	        System.out.println(pageName);

	        JSONArray arr = obj.getJSONArray("fields");
	        for (int i = 0; i < arr.length(); i++) {
	            String post_id = arr.getJSONObject(i).getString("name");
	            System.out.println(post_id);
	        }
	    }
	
	
}