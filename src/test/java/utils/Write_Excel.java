package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Excel 
{
	public static void ExcelR_W (String excelPath, String excelOutPath) throws Throwable
	{
	FileInputStream fi=new FileInputStream(excelPath);
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFSheet ws=wb.getSheetAt(0);
	XSSFRow r=ws.getRow(0);
	int rc=ws.getLastRowNum();
	int cc=r.getLastCellNum();
System.out.println("no of rows are::"+rc+"  "+"no of columns are::"+cc);
for(int i=1;i<=rc;i++)
{
String username=ws.getRow(i).getCell(0).getStringCellValue();
String password=ws.getRow(i).getCell(1).getStringCellValue();
System.out.println(username+"  "+password);
//write as pass into results column
ws.getRow(i).createCell(2).setCellValue("Pass");
}
fi.close();
//writing into new Workbook
FileOutputStream fo=new FileOutputStream(new File(excelOutPath));
wb.write(fo);
fo.close();
wb.close();
	}

}
