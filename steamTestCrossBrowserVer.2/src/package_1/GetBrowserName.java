package package_1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class GetBrowserName {
	
	public static String getBrowserName() throws IOException {
	  File fileName = new File("C:\\Users\\User\\eclipse-workspace\\steam\\src\\package_1\\BrowserName.properties");
	  Charset charset = Charsets.US_ASCII;
	  return Files.toString(fileName, charset);
	}
	
}