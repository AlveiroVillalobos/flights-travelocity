package com.fligths.travelocity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[contains(text(),'Flights')]/ancestor::a")
    public WebElement tabFlights;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
