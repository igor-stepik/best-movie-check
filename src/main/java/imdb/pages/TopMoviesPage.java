package imdb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;


public class TopMoviesPage {
    private final WebDriver driver;

    private final String FAVORITE_MOVIE_TITLE = "The Godfather";
    List<Movie> GodFatherInfo = new ArrayList<>();
    List<Movie> topFiveMovies = new ArrayList<>();

    private final By bestMovieTitle = By.cssSelector("[data-testid='hero-title-block__title']");
    private final By bestMovieYear = By.xpath("/html/body/div[2]/main/div/section[1]" +
            "/section/div[3]/section/section/div[2]/div[1]/div/ul/li[1]/a");
    private final By bestMovieRating = By.cssSelector("[data-testid='hero-rating-bar__aggregate-rating__score']" +
            " :nth-child(1)");
    private final By topMoviesElements = By.xpath("//*[@data-caller-name='chart-top250movie']/tbody//tr");
    String godFatherDetailUrl = "https://www.imdb.com/title/tt0068646";

    public TopMoviesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getTopFiveMovies() {
        List<WebElement> allTopMovies = driver.findElements(topMoviesElements);
        for (int i = 0; i < 5; i++) {
            String movieTitle = allTopMovies.get(0).findElements(By.xpath("//td[2]/a")).get(i).getText();
            String movieYear = allTopMovies.get(0).findElements(By.xpath("//td[2]/span")).get(i).getText()
                    .replaceAll("\\D", "");
            String movieRating = allTopMovies.get(0).findElements(By.xpath("//td[3]/strong")).get(i).getText();
            topFiveMovies.add(new Movie(movieTitle, movieRating, movieYear));
        }
    }

    public void checkIsGodFatherInTopFiveList() {
        Assert.assertTrue(topFiveMovies.stream().anyMatch(movie ->
                Objects.equals(movie.getName().toUpperCase(Locale.ROOT),
                        FAVORITE_MOVIE_TITLE.toUpperCase(Locale.ROOT))), "GODFATHER NOT IN TOP FIVE ANYMORE!!!");

        setGodFatherInfo(topFiveMovies.stream().filter(movie ->
                movie.getName().equals(FAVORITE_MOVIE_TITLE)).collect(Collectors.toList()));

    }

    public void setGodFatherInfo(List<Movie> list) {
        this.GodFatherInfo = list;
    }

    public void openGodFatherPage() {

        driver.get(godFatherDetailUrl);
    }

    public String getBestMovieTitle() {
        return driver.findElement(bestMovieTitle).getText();
    }

    public String getBestMovieYear() {
        return driver.findElement(bestMovieYear).getText();
    }

    public String getBestMovieRating() {
        return driver.findElement(bestMovieRating).getText();

    }

    public void comparingRating() {
        Assert.assertEquals(GodFatherInfo.get(0).getName(), getBestMovieTitle(), "MOVIE TITLE NOT EQUALS");
        Assert.assertEquals(GodFatherInfo.get(0).getRating(), getBestMovieRating(), "MOVIE RATING NOT EQUALS");
        Assert.assertEquals(GodFatherInfo.get(0).getYear(), getBestMovieYear(), "MOVIE YEAR NOT EQUALS");

    }
}
