package tests;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import data.CsvReader;

public class Test {

	public static void main(String[] args) throws CsvValidationException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println(CsvReader.getNumberOfRow("userData"));
		// read the csv file
		String CsvPath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\"+"userData"+".csv";
		CSVReader reader = new CSVReader(new FileReader(CsvPath));
		// put first row in Csvdata[]
		String CsvData[] = reader.readNext();
		int numberOfRow = CsvReader.getNumberOfRow("userData");
		int x=0;
		for(int index1=0;index1 <numberOfRow;index1++) {
			for(int index2 =0 ; index2<4;index2++) {
				if(x < (4*numberOfRow))
				{
					
					x++;
				}
			}
		}
		System.out.println(x);
		while(CsvData != null) {
		
		for(String data:CsvData) {
			
			System.out.println(data);
			
		}
		   CsvData = reader.readNext();
		}

	}

}
