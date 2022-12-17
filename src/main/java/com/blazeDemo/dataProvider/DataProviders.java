package com.blazeDemo.dataProvider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.blazeDemo.utility.ExcelLibrary;

public class DataProviders {

	ExcelLibrary obj = new ExcelLibrary();

	@DataProvider(name = "fromToFlight")
	public Object[][] getFromTo() {
		// Total rows count
		int rows = obj.getRowCount("Sheet1");
		// Total colums Count
		int column = obj.getColumnCount("Sheet1");

		Object[][] data = new Object[rows - 1][column];

		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Sheet1", j, i + 2);
			}
		}

		return data;
	}
	
	@DataProvider(name = "detailsPage")
	public Object[][] accountCreation() {

		// Totals rows count
		int rows = obj.getRowCount("Sheet2");
		// Total Columns
		int column = obj.getColumnCount("Sheet2");
		int actRows = rows - 1;
		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];
		
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < column; j++) {
				hashMap.put(obj.getCellData("Sheet2", j, 1),
						obj.getCellData("Sheet2", j, i + 2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}


}
