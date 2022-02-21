package com.fligths.travelocity.test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fligths.travelocity.pages.FlightsPage;
import com.fligths.travelocity.pages.HomePage;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static com.fligths.travelocity.utils.Utils.highlightElement;
import static com.fligths.travelocity.utils.Utils.takeScreenshot;

public class ValidateFlightTypesTest extends TestBase{

    @Test
    public void validateFlightTypes() throws IOException {
        driver.get(url);
        test = extent.createTest("Validacion tabs tipos de vuelos");
        HomePage homePage = new HomePage(driver);
        FlightsPage flightsPage = new FlightsPage(driver);
        homePage.tabFlights.click();
        Assert.assertEquals("Roundtrip",flightsPage.tabRoundtrip.getText());
        highlightElement(driver, flightsPage.tabRoundtrip);
        Assert.assertEquals("One-way",flightsPage.tabOneWay.getText());
        highlightElement(driver, flightsPage.tabOneWay);
        Assert.assertEquals("Multi-city",flightsPage.tabMultiCity.getText());
        highlightElement(driver, flightsPage.tabMultiCity);
        screenshotPath = takeScreenshot(driver, "img");
        test.pass("Ingresa Correctamente a la opcion Flights y se visulizan todos los tab de tipos de vuelos",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
}
