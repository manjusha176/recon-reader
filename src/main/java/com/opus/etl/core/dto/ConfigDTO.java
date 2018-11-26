package com.opus.etl.core.dto;

import java.util.ArrayList;
import java.util.List;

public class ConfigDTO {
	private String sourceType;
	private String sourcePath;
	private String fieldSeperator;
	private boolean isheader;
	
	private String headerRow;
	private String recordSeperator;
	private List <Field>fieldList;

	public ConfigDTO(){
		fieldList = new ArrayList<Field>();
	}

	public ConfigDTO(String sourceType, String sourcePath, String fieldSeperator, boolean isheader, String headerRow,
			String recordSeperator, List<Field> fieldList) {
		this.sourceType = sourceType;
		this.sourcePath = sourcePath;
		this.fieldSeperator = fieldSeperator;
		this.isheader = isheader;
		this.headerRow = headerRow;
		this.recordSeperator = recordSeperator;
		this.fieldList = fieldList;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getSourcePath() {
		return sourcePath;
	}

	public void setSourcePath(String sourcePath) {
		this.sourcePath = sourcePath;
	}

	public String getFieldSeperator() {
		return fieldSeperator;
	}

	public void setFieldSeperator(String fieldSeperator) {
		this.fieldSeperator = fieldSeperator;
	}

	public boolean isIsheader() {
		return isheader;
	}

	public void setIsheader(boolean isheader) {
		this.isheader = isheader;
	}

	public String getHeaderRow() {
		return headerRow;
	}

	public void setHeaderRow(String headerRow) {
		this.headerRow = headerRow;
	}

	public String getRecordSeperator() {
		return recordSeperator;
	}

	public void setRecordSeperator(String recordSeperator) {
		this.recordSeperator = recordSeperator;
	}

	public List<Field> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}
	

}
