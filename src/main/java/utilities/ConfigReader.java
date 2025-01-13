package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	

	/**
	 * This method is used to load the properties from config.properties file
	 * 
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {

		Properties prop = new Properties();
		
			FileInputStream ip = null;
			try {
				ip = new FileInputStream("./src/test/resources/config/browser_config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return prop;

	}

}
