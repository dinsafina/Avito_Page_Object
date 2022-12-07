package org.avito;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchCity {
    WebDriver driver;

    public SearchCity(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy
            (xpath = "//div[@data-marker=\"search-form/region\"]")
    private WebElement inputCity;

    @FindBy
            (xpath = "//input[@placeholder=\"Город или регион\"]")
    private WebElement entryCity;


    @FindBy
            (xpath = "//li[@data-marker=\"suggest(0)\"]")
    public WebElement ChangedCity;

    @FindBy
            (xpath = "//button[@data-marker=\"popup-location/save-button\"]")
    public WebElement showAdsButton;


    public SearchCity inputCityClick() {
        inputCity.click();
        return this;
    }

    public SearchCity entryCityClick(String city) {
        if (!city.isEmpty()) {
            entryCity.sendKeys(city);
            return this;
        } else {
            throw new IllegalArgumentException("empty city value");
        }
    }

    public SearchCity VladivostokClick() {
        WebElement waitingEnteredCity = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[text() = 'Владивосток']"))));

        ChangedCity.click();
        return this;
    }

    public SearchCity showAdsButtonClick() {
        showAdsButton.click();
        return this;
    }
}
