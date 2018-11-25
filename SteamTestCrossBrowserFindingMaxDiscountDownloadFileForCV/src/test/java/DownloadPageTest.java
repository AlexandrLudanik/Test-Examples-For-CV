import org.junit.Test;
import org.testng.Assert;

import java.io.File;

public class DownloadPageTest extends WebDriverSettings{


    @Test
    public void downloadFile() throws InterruptedException {
        homePage.clickButtonSetup();
        downloadPage.downloadFile();

        //wait
        Thread.sleep(5000);
        File listOfFiles[] = folder.listFiles();
        //make sure the directory is not empty
        //  Assert.assertEquals(listOfFiles.length, is(not(0)));
        Assert.assertTrue(listOfFiles.length>0);

        for(File file : listOfFiles){
            //make sure that downloaded fle is not empty
            // Assert.assertEquals(file.length(), is(not((long)0)));
            Assert.assertTrue(file.length()>0);
        }
    }
}