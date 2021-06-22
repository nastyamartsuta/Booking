package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingMainPage extends BasePage{

    public static final String BASE_URL = "https://www.booking.com/searchresults.en-gb.html";

    public static final By DESTINATION_INPUT = By.id("ss");
    public static final By SEARCH_BUTTON = By.xpath(".sb-searchbox__button");

    public BookingMainPage(WebDriver driver) {
        super(driver);
    }

    public BookingMainPage open() {
        driver.get(BASE_URL);
        return this;
    }

    public BookingMainPage enterLocation(String location) {
        driver.findElement(DESTINATION_INPUT).sendKeys(location);
        return this;
    }

    public BookingMainPage clickSearchButton() {
        driver.findElement(SEARCH_BUTTON).click();
        return new BookingMainPage(driver);
    }
}
