package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class JsonDataReader {
	
	public String firstName,lastName, email,password;
	
	public void jsonReader() throws  IOException, ParseException {
		
		String jsonFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.json";
		File src = new File(jsonFilePath);
		JSONParser parser = new JSONParser();
		JSONArray dataArray = (JSONArray) parser.parse(new FileReader(src));
		for(Object json:dataArray) {
			
			 JSONObject user = (JSONObject) json;
			 firstName = (String)user.get("firstName");
			 lastName  = (String)user.get("lastName");
			 email     = (String)user.get("email");
			 password  = (String)user.get("password");
			 
			
		}
		
		
		
	}

}
