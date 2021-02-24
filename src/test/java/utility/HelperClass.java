package utility;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HelperClass {
	
	public static Integer x;
	
	public static void takeScreenShoot(WebDriver driver , String screenShootName)  {
		
		Path dest = Paths.get("./screenShoots//"+screenShootName+".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("exception from take screen shoot"+e.getMessage());
		}
		
	}

}
