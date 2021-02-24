package data;


import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvReader {
	
	public static int getNumberOfRow ( String fileName) throws CsvValidationException, IOException
	{
		int count =0;
		String CsvPath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\"+fileName+".csv";
		CSVReader reader = new CSVReader(new FileReader(CsvPath));
		String[] data = reader.readNext();
		while(data != null) {
			count++;
			data = reader.readNext();
		}
		
	
	return count;  
	}
	
	
	
	public static Object[][] readCsvFile( String fileName ,int NumberOfDataPerRow) throws CsvValidationException, IOException{
		// get number of row
		int numberOfRow = getNumberOfRow(fileName);
		// read the csv file
		String CsvPath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\"+fileName+".csv";
		CSVReader reader = new CSVReader(new FileReader(CsvPath));
		// put first row in Csvdata[]
		String CsvData[] = reader.readNext();
		// return data to use in @DataProvider
		Object[][] data= new Object[numberOfRow][NumberOfDataPerRow];
		// variable for CsvData
		
			for(int index1=0;index1 <numberOfRow;index1++) {
				for(int index2 =0 ; index2<NumberOfDataPerRow;index2++) {
					
						data[index1][index2] = CsvData[index2];
					
				}
				CsvData= reader.readNext();
			}
		
			 return data;
		}
	 
		

}
