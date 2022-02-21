package com.fligths.travelocity.test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.fligths.travelocity.pages.FlightsPage;
import com.fligths.travelocity.pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;

import static com.fligths.travelocity.utils.Utils.*;

public class ValidateFormFlightOneWayTest extends TestBase{

    @Test
    public void validateFormFlightOneWayTest() throws IOException {
        driver.get(url);
        test = extent.createTest("Validar campos formulario vuelo tipo One-Way");
        HomePage homePage = new HomePage(driver);
        FlightsPage flightsPage = new FlightsPage(driver);
        homePage.tabFlights.click();
        flightsPage.tabOneWay.click();
        ArrayList<WebElement> elementsForm = new ArrayList<>();
        elementsForm.add(flightsPage.btnLeavingFrom);
        elementsForm.add(flightsPage.btnGoingTo);
        elementsForm.add(flightsPage.btnDateDeparting);
        elementsForm.add(flightsPage.sectionAddPlace);
        elementsForm.add(flightsPage.sectionTravelers);
        elementsForm.add(flightsPage.sectionFlightClass);
        elementsForm.add(flightsPage.btnSearch);

        if(isElementPresent(elementsForm)){
            highlightElement(driver, elementsForm);
            screenshotPath = takeScreenshot(driver, "img");
            test.pass("Campos del formulario vuelo One-Way son correctos", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }else{
            screenshotPath = takeScreenshot(driver, "img");
            test.fail("Campos del formulario vuelo One-Way NO son correctos", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }
}
