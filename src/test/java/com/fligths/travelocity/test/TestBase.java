package com.fligths.travelocity.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fligths.travelocity.utils.Utils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    public static String url;
    public static String screenshotPath;

    @BeforeClass
    public static void setupTest() {
        extentReportSetup();
        Utils.pathFileProperties = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        String browser = Utils.getProperties("browser");
        url = Utils.getProperties("url");

        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> {
                System.out.println("Navegador NO soportado, navegadores disponibles chrome, edge, firefox");
            }
        }

        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
        extent.flush();
    }

    public static void extentReportSetup() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/report/report-automation.html");
        extent.attachReporter(spark);
    }
}
