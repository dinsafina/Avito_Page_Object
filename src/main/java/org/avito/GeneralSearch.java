package org.avito;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class GeneralSearch {

    WebDriver driver;

    public GeneralSearch(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy
            (xpath = "//select[@id = 'category']")
    private WebElement category;

    @FindBy
            (xpath = "//button[@class = 'top-rubricator-rubricatorButton-SoKyQ button-button-CmK9a button-size-m-LzYrF button-primary-x_x8w']")
    private WebElement alternativeCategory;

    @FindBy
            (xpath = "//input[@aria-autocomplete='list']")
    private WebElement searchField;

    @FindBy
            (xpath = "//div[@data-marker=\"search-form/region\"]")
    private WebElement inputCity;

    public GeneralSearch clickElectronics(String categoryName) {
        boolean isPresent = driver.findElements(By.xpath("//select[@id = 'category']")).size() > 0;
        if (isPresent) {
            Select select = new Select(category);
            select.selectByVisibleText(categoryName);
            return this;
        } else {
            alternativeCategory.click();
        }
        return this;
    }


    public GeneralSearch clickOfficeEquipment(String generalCategory, String subCategory) {
        boolean isPresent = driver.findElements(By.xpath("//select[@id = 'category']")).size() > 0;
        if (isPresent) {
            Select select = new Select(category);
            select.selectByVisibleText(subCategory);
            return this;
        } else {
            Actions actions = new Actions(driver);
            WebElement menuOption = driver.findElement(By.xpath(".//p[contains(text(), " + generalCategory + ")]"));
            actions.moveToElement(menuOption).perform();
            WebElement subMenuOption = driver.findElement(By.xpath(".//strong[contains(text(), " + subCategory + ")]"));
            subMenuOption.click();
        }
        return this;
    }

    public GeneralSearch enterSearchField(String text) {
        if (!text.isEmpty()) {
            searchField.sendKeys(text, Keys.ENTER);
            return this;
        } else {
            throw new IllegalArgumentException("empty value of the input field");
        }
    }

     public SearchCity inputCityClick() {
        inputCity.click();
        return new SearchCity(driver);
    }
}
