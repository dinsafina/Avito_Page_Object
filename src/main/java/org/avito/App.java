package org.avito;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class App {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();

        GeneralSearch generalSearch = PageFactory.initElements(driver, GeneralSearch.class);

        generalSearch
                .clickElectronics("Электроника")
                .clickOfficeEquipment("Электроника", "Оргтехника и расходники")
                .enterSearchField("Принтер");

        SearchCity searchCity = PageFactory.initElements(driver, SearchCity.class);

        searchCity
                .inputCityClick()
                .entryCityClick("Владивосток")
                .VladivostokClick()
                .showAdsButtonClick();

        SearchSettings searchSettings = PageFactory.initElements(driver, SearchSettings.class);

        searchSettings
                .dropDownClick()
                .expensiveClick()
                .showFirstThreeResults();
    }
}


