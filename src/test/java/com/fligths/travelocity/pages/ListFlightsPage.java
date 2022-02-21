package com.fligths.travelocity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListFlightsPage {

    @FindBy(xpath = "//span[contains(text(),'Review your trip')]")
    public WebElement labelReviewTrip;

    public ListFlightsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
