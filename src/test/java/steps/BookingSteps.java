package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import pages.BookingMainPage;
import pages.BookingSearchPage;

import java.util.concurrent.TimeUnit;

public class BookingSteps {
    String location;
    String hotelName;
    WebDriver driver;
    WebDriverWait wait;

    protected BookingMainPage bookingMainPage;
    protected BookingSearchPage bookingSearchPage;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //НЕЯВНЫЕ ОЖИДАНИЯ
        bookingMainPage = new BookingMainPage(driver);
        bookingSearchPage = new BookingSearchPage();
    }

    @Given("Enter destination\\/property name")
    public void enterDestinationPropertyName() {
        this.location = location;
    }

    @When("User does search")
    public void userDoesSearch() {
        bookingMainPage
                .open()
                .enterLocation(location)
                .clickSearchButton();
    }

    @Then("Hotel <hotel> is on the first page")
    public void hotelHotelIsOnTheFirstPage() {
    }

    @And("Check hotel rating")
    public void checkHotelRating() {
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
