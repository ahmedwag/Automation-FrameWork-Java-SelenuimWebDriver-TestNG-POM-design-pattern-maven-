package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ReadProperties {
	
	
	public static Properties userData = 
			LoadProperties(System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.properties");
	
	
	private static Properties  LoadProperties(String path) {
		
		
		Properties pro = new Properties();
		// stream for reading the file
		try {
			FileInputStream  stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("error occured"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error occured"+e.getMessage());
		}
		return pro;
	}
	
		
		
	

}
