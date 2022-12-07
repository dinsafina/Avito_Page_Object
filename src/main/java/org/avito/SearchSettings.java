package org.avito;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchSettings {
    WebDriver driver;

    public SearchSettings(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy
            (xpath = "//div[@class=\"select-select-box-jJiQW select-size-s-VX5kS\"]")
    public WebElement dropDown;
    @FindBy
            (xpath = "//option[text()= 'Дороже']")
    private WebElement selectExpensive;

    public SearchSettings dropDownClick() {
        dropDown.click();
        WebElement waitingExpensive = (new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[text()= 'Дороже']"))));
        return this;
    }

    public SearchSettings expensiveClick() {
        selectExpensive.click();
        return this;
    }

    public void showFirstThreeResults() {
        List<WebElement> products = driver.findElements(By.xpath("//h3[@itemprop=\"name\"]"));
        List<WebElement> priceSublist = products.subList(1, 4);

        List<WebElement> products2 = driver.findElements(By.xpath("//span[@class=\"price-text-_YGDY text-text-LurtD text-size-s-BxGpL\"]"));
        List<WebElement> priceSublist2 = products2.subList(1, 4);

        for (int i = 0; i < priceSublist.size(); i++) {
            System.out.println(priceSublist.get(i).getText() + ", цена: " + priceSublist2.get(i).getText());
        }
    }
}
