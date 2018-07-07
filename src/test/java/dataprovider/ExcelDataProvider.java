package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
			
		File src = new File("./AppTestData/AppData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception = " + e.getMessage());
		}		
	}
	
	public String getData(int sheetIndex, int row, int col ) {
		
		return wb.getSheetAt(0).getRow(row).getCell(col).getStringCellValue();
		 
	}
}
