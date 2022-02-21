package com.fligths.travelocity.test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fligths.travelocity.pages.FlightsPage;
import com.fligths.travelocity.pages.HomePage;
import com.fligths.travelocity.pages.ListFlightsPage;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import java.io.IOException;

import static com.fligths.travelocity.utils.Utils.isElementPresent;
import static com.fligths.travelocity.utils.Utils.takeScreenshot;

public class SearchFlightRoundTripTest extends TestBase{

    @Test
    public void SearchFlightRoundTrip() throws InterruptedException, IOException {
        driver.get(url);
        test = extent.createTest("Buscar un vuelo de tipo RoundTrip");
        HomePage homePage = new HomePage(driver);
        FlightsPage flightsPage = new FlightsPage(driver);
        ListFlightsPage listFlightsPage = new ListFlightsPage(driver);
        homePage.tabFlights.click();
        flightsPage.tabRoundtrip.click();
        flightsPage.btnLeavingFrom.click();
        flightsPage.inputLeavingFrom.sendKeys("BOG");
        flightsPage.inputLeavingFrom.sendKeys(Keys.ENTER);
        flightsPage.btnGoingTo.click();
        flightsPage.inputGoingTo.sendKeys("CLO");
        flightsPage.inputGoingTo.sendKeys(Keys.ENTER);
        screenshotPath = takeScreenshot(driver, "img");
        test.info("Se ingresa ciudad origen y destino", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        flightsPage.btnSearch.click();

        if(isElementPresent(listFlightsPage.labelReviewTrip)){
            screenshotPath = takeScreenshot(driver, "img");
            test.info("Se vizualisa la lista de vuelos disponibles", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }else{
            screenshotPath = takeScreenshot(driver, "img");
            test.fail("Error en la busqueda del vuelo", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
}
