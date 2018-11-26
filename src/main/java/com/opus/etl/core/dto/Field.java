package com.opus.etl.core.dto;

public class Field {
	private String fieldName;
	private String fieldType;
	private int fieldIndex;

	public Field(String fieldName, String fieldType, int fieldIndex) {
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.fieldIndex = fieldIndex;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public int getFieldIndex() {
		return fieldIndex;
	}

	public void setFieldIndex(int fieldIndex) {
		this.fieldIndex = fieldIndex;
	}
}
