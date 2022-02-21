package com.fligths.travelocity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {

    @FindBy(xpath = "//span[contains(text(),'Roundtrip')]/ancestor::a")
    public WebElement tabRoundtrip;

    @FindBy(xpath = "//span[contains(text(),'One-way')]/ancestor::a")
    public WebElement tabOneWay;

    @FindBy(xpath = "//span[contains(text(),'Multi-city')]/ancestor::a")
    public WebElement tabMultiCity;

    @FindBy(xpath = "//button[contains(@aria-label,'Leaving from')]")
    public WebElement btnLeavingFrom;

    @FindBy(xpath = "//button[contains(@aria-label,'Going to')]")
    public WebElement btnGoingTo;

    @FindBy(xpath = "//input[contains(@placeholder,'Where are you leaving from?')]")
    public WebElement inputLeavingFrom;

    @FindBy(xpath = "//input[contains(@placeholder,'Where are you going to?')]")
    public WebElement inputGoingTo;

    @FindBy(xpath = "//ul[contains(@data-stid,'location-field-leg1-origin-results')]/li[1]")
    public WebElement optionOriginCity;

    @FindBy(xpath = "//ul[contains(@data-stid,'location-field-leg1-destination-results')]/li[1]")
    public WebElement optionDestinationCity;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement btnSearch;

    @FindBy(xpath = "//button[contains(@id,'d1-btn')]")
    public WebElement btnDateDeparting;

    @FindBy(xpath = "//button[contains(@id,'d2-btn')]")
    public WebElement btnDateReturning;

    @FindBy(xpath = "//input[contains(@id,'add-hotel-checkbox')]/parent::div")
    public WebElement sectionAddPlace;

    @FindBy(xpath = "//input[contains(@id,'add-car-checkbox')]/parent::div")
    public WebElement sectionAddCar;

    @FindBy(id = "adaptive-menu")
    public WebElement sectionTravelers;

    @FindBy(id = "preferred-class-input")
    public WebElement sectionFlightClass;

    public FlightsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
