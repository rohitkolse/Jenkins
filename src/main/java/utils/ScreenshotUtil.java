package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String testName) {

        try {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            File dest = new File("screenshots/" + testName + ".png");

            FileUtils.copyFile(src, dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
