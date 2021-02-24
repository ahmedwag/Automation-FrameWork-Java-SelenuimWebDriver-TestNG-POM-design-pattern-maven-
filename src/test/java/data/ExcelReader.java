package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {


	static FileInputStream fis = null;

	public FileInputStream getFileInputStream() {

		String path  = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.xlsx";
		FileInputStream temp= null;
		File src = new File(path);
		try {
			temp= new FileInputStream(src);
		} catch (FileNotFoundException e) {
			System.out.println("error happened "+e.getMessage());
		}

		return temp;


	}


	public Object[][] getExcelData() throws IOException{


		fis = getFileInputStream();

		
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // get first sheet in the excel file
			int rowNumber = (sheet.getLastRowNum()+1);
			int columnNuumber = 4;

			String[][]  arrayOfData= new String[rowNumber][columnNuumber];

			for (int i=0;i < rowNumber;i++) {
				XSSFRow row = sheet.getRow(i);
				for(int j=0; j<columnNuumber;j++) {

					arrayOfData[i][j] =row.getCell(j).toString();
				}
			}
			wb.close();
			return arrayOfData;
		

	}
	
	
	

}



