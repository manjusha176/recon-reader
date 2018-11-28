package com.opus.etl.core.dto;

public class Field {
	private String fieldName;
	private String fieldType;
	private int fieldIndex;
	private int fieldSize;

	public Field(String fieldName, String fieldType, int fieldIndex, int fieldSize) {
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.fieldIndex = fieldIndex;
		this.fieldSize = fieldSize;
	}

	public int getFieldSize() {
		return fieldSize;
	}

	public void setFieldSize(int fieldSize) {
		this.fieldSize = fieldSize;
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
