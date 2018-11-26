package com.opus.etl.core.field;

import java.util.ArrayList;
import java.util.List;

public class CSVFieldValidator {

	public List<String> parseLine(String cvsLine, char separators, char customQuote) {

		List<String> result = new ArrayList<>();

		// if empty, return!
		if (cvsLine == null && cvsLine.isEmpty()){
			return result;
		}

		StringBuilder curVal = new StringBuilder();
		boolean inQuotes = false;
		boolean startCollectChar = false;
		boolean doubleQuotesInColumn = false;

		char[] chars = cvsLine.toCharArray();

		for (char ch : chars){

			if (inQuotes){
				startCollectChar = true;
				if (ch == customQuote){
					inQuotes = false;
					doubleQuotesInColumn = false;
				} else{

					// Fixed : allow "" in custom quote enclosed
					if (ch == '\"'){
						if (!doubleQuotesInColumn){
							curVal.append(ch);
							doubleQuotesInColumn = true;
						}
					} else{
						curVal.append(ch);
					}

				}
			} else{
				if (ch == customQuote){

					inQuotes = true;

					/*
					 * // Fixed : allow "" in empty quote enclosed if (chars[0] != '"' && customQuote == '\"'){ // curVal.append('"'); }
					 */

					// double quotes in column will hit this!
					if (startCollectChar){
						curVal.append('"');
					}

				} else if (ch == separators){

					result.add(curVal.toString());

					curVal = new StringBuilder();
					startCollectChar = false;

				} else if (ch == '\r'){
					// ignore LF characters
					continue;
				} else if (ch == '\n'){
					// the end, break!
					break;
				} else{
					curVal.append(ch);
				}
			}

		}

		result.add(curVal.toString());
		System.out.println("Result--------->" + result + "list size--" + result.size());

		return result;
	}

}
