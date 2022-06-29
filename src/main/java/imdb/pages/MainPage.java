package imdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class MainPage {
    private final WebDriver driver;

    private final By navigationButton = By.xpath("/html/body/div[2]/nav/div[2]/label[2]/div");
    private final By topMoviesButton = By.xpath("//div //ul //a[3] [@href=\"/chart/top/?ref_=nv_mv_250\"]");
    private final String topMoviesPageTitle = "Top 250 Movies - IMDb";
    private final String URL = "https://www.imdb.com";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(URL);
    }

    public void navigateToTopMoviesPage() {

        driver.findElement(navigationButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(topMoviesButton));
        driver.findElement(topMoviesButton).click();
        Assert.assertEquals(driver.getTitle(), topMoviesPageTitle,
                "FAILED NAVIGATION TO TOP 250 MOVIES LIST");
    }
}
