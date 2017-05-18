package com.test.baseTests;

import java.util.List;
import java.util.logging.Level;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;

import com.test.app.ApplicationManager;

import ru.yandex.qatools.allure.annotations.Attachment;

public class TestBase {

	  protected ApplicationManager app;
	 	 	  
		@Before
		public void init() throws Exception {
						
			app = new ApplicationManager();								
		}
						
		@After
		public void stop() throws InterruptedException {
			
			String reportTitle = "LogFile";
								
			makeScreenshot();                             //  make Screenshot
		         
	        saveTextLog(reportTitle, getReportString());  // make Log file for report  
		    
		    app.stop();		                              // app stop
		}
				
		private String getReportString() {
			
			String report = "";
			
			Logs log = app.getWebDriver().manage().logs();
	       
			List<LogEntry> logsEntries = log.get("browser").filter(Level.SEVERE);

	        for (LogEntry entry: logsEntries) {
               report +=  entry.getMessage() + "\r\n";
	        }
	        
	        return report;
		}

		@Attachment(type = "image/png")
		public byte[] makeScreenshot() {
						
		   return ((TakesScreenshot) app.getWebDriver()).getScreenshotAs(OutputType.BYTES);
		}
	  
	   @Attachment(value = "{0}", type = "text/plain")
	    public static String saveTextLog(String attachName, String message) {
	        return message;
	    }
	
	  	  		
}
