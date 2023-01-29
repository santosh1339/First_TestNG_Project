package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("C:\\Users\\Santosh.A\\eclipse-workspace\\First_TestNG_Project\\DataSource.xls");
		
		FileInputStream fis = new FileInputStream(file);
		
		HSSFWorkbook wb = new HSSFWorkbook(fis); 
		
		// when working with .xls workbnook format [ Horribale Spreadsheet format ] if xlsx we use XSSF 
		
		HSSFSheet sh = wb.getSheetAt(0); 
		
		//by default the index is 0 and getsheet will get the sheet1 , if you want to pull the sheet by sheetname then 
		
		int rowCount = sh.getLastRowNum() -sh.getFirstRowNum();
		int cellCount = sh.getRow(1).getLastCellNum();
		
		String arr[][] = new String[rowCount+1][cellCount];
		
		for(int i=0; i<=rowCount; i++)
		{
			for(int j=0; j<cellCount; j++)
			{
				arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		for(int k=1; k<arr.length ; k++)
		{
			for (int l=0; l<cellCount; l++)
			{
				System.out.print(arr[k][l] + ",");
			}
			System.out.println();
		}
		
	}

}


