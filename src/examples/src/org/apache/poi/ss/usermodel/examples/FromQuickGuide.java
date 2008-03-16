/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
package org.apache.poi.ss.usermodel.examples;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Various things from the quick guide documentation
 */
public class FromQuickGuide {
	public void newWorkbook() throws IOException {
		boolean doHSSF = true;
		boolean doXSSF = true;
		
		if(doHSSF) {
		    Workbook wb = new HSSFWorkbook();
		    FileOutputStream fileOut = new FileOutputStream("workbook.xls");
		    wb.write(fileOut);
		    fileOut.close();
		}
		if(doXSSF) {
		    Workbook wb = new XSSFWorkbook();
		    FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
		    wb.write(fileOut);
		    fileOut.close();
		}
	}
	
	public void newSheet() throws IOException {
		Workbook[] wbs = new Workbook[] {
				new HSSFWorkbook(), new XSSFWorkbook()
		};
		
		for (int i = 0; i < wbs.length; i++) {
			Workbook wb = wbs[i];
		    Sheet sheet1 = wb.createSheet("new sheet");
		    Sheet sheet2 = wb.createSheet("second sheet");
		    FileOutputStream fileOut = new FileOutputStream("workbook.xls");
		    wb.write(fileOut);
		    fileOut.close();
		}
	}
	
	public void newCells() throws IOException {
		Workbook[] wbs = new Workbook[] {
				new HSSFWorkbook(), new XSSFWorkbook()
		};
		
		for (int i = 0; i < wbs.length; i++) {
			Workbook wb = wbs[i];
		    Sheet sheet = wb.createSheet("new sheet");

		    // Create a row and put some cells in it. Rows are 0 based.
		    Row row = sheet.createRow((short)0);
		    // Create a cell and put a value in it.
		    Cell cell = row.createCell((short)0);
		    cell.setCellValue(1);

		    // Or do it on one line.
		    row.createCell((short)1).setCellValue(1.2);
		    row.createCell((short)2).setCellValue(
		    		cell.createRichTextString("This is a string"));
		    row.createCell((short)3).setCellValue(true);

		    // Write the output to a file
		    FileOutputStream fileOut = new FileOutputStream("workbook.xls");
		    wb.write(fileOut);
		    fileOut.close();
		}
	}
}
