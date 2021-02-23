package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel 
{
	Workbook wb;
	FileOutputStream fo;

	//Getting Excel File Path
	public Excel(String excelpath) throws Throwable
	{
		FileInputStream fi=new FileInputStream(excelpath);
		wb=WorkbookFactory.create(fi);
	}

	//Getting No Of Rows in a Sheet
	public int rowCount(String sheetname)
	{
		return wb.getSheet(sheetname).getLastRowNum();
	}

	//Getting No of Columns for a Row
	public int colCount(String sheetname)
	{
		return wb.getSheet(sheetname).getRow(0).getLastCellNum();
	}

	//Read Each Cell Data
	public String getcelldata(String sheetname,int row,int column)
	{
		String data="";
		if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==CellType.NUMERIC)
		{
			int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			data=String.valueOf(celldata);
		}
		else
		{
			data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();	
		}
		return data;
	}

	//Setting Result Status to a Cell
	public void setCelldata(String sheetname,int row,int column,
			String status,String outputpath)throws Throwable
	{
		wb.getSheet(sheetname).getRow(row).createCell(column).setCellValue(status);
		fo=new FileOutputStream(new File(outputpath));
		wb.write(fo);
	}

	//Setting Pass Green Color To a Cell
	public void greencolour(String sheetname,int row,int column,String outputpath)
	{
		Sheet ws=wb.getSheet(sheetname);
		CellStyle style =wb.createCellStyle();
		Font font=wb.createFont();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		//Apply Bold To The Text
		font.setBold(true);
		style.setFont(font);
		ws.getRow(row).getCell(column).setCellStyle(style);

		try 
		{
			fo=new FileOutputStream(new File(outputpath));
			wb.write(fo);
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
	}

	//Filling Red Fail color to a Cell
	public void redcolour(String sheetname,int row,int column,String outputpath)
	{
		Sheet ws=wb.getSheet(sheetname);
		CellStyle style =wb.createCellStyle();
		Font font=wb.createFont();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setFont(font);
		ws.getRow(row).getCell(column).setCellStyle(style);
		try
		{
			fo=new FileOutputStream(new File(outputpath));
			wb.write(fo);
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
	}


	public void closefiles()throws Throwable
	{
		wb.close();
		fo.close();
	}

}
