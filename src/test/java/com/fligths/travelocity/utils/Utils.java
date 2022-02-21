package com.fligths.travelocity.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Utils {

    public static String pathFileProperties = null;

    public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/target/report/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    public static void highlightElement(WebDriver driver, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", webElement);
    }

    public static void highlightElement(WebDriver driver, ArrayList<WebElement> listWebElements) {
        for (int i = 0; i < listWebElements.size(); i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", listWebElements.get(i));
        }
    }

    public void setupPathFileProperties(String path) {
        pathFileProperties = path;
    }

    public static String getProperties(String namePropertie) {
        String propertie = null;
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream(pathFileProperties);
            properties.load(input);
            propertie = properties.getProperty(namePropertie);
            System.out.println(propertie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return propertie;
    }

    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isSelected();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementPresent(ArrayList<WebElement> webElement) {
        boolean flag = false;
        for (int i = 0; i < webElement.size(); i++) {
            try {
                webElement.get(i).isDisplayed();
                flag = true;
            } catch (NoSuchElementException e) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
