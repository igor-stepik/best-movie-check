package com.imdb.pages;

import com.imdb.Movie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class TopMoviesPage {
    private WebDriver driver;
    final String favoriteMovieTitle = "The Godfather";
    List<Movie> topFiveList = new ArrayList<>();
    List<Movie> GodFatherInfo = new ArrayList<>();

    public TopMoviesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void CheckIsMovieInTop() {
        for (int i = 1; i < 6; i++) {
            String titleName = driver.findElement(By.cssSelector(".lister-list tr:nth-child(" + i + ") td:nth-child(2) a")).getText();
            String year = driver.findElement(By.cssSelector(".lister-list tr:nth-child(" + i + ") td:nth-child(2) span")).getText();
            year =  year.substring(1, year.length() - 1);
            String rating = driver.findElement(By.cssSelector(".lister-list tr:nth-child(" + i + ") td:nth-child(3) strong")).getText();
            topFiveList.add(new Movie(titleName, rating, year));
        }
        Assert.assertTrue(topFiveList.stream().anyMatch(film -> Objects.equals(film.getName().toUpperCase(Locale.ROOT), favoriteMovieTitle.toUpperCase(Locale.ROOT))));
         setGodFatherInfo(topFiveList.stream().filter(movie -> movie.getName().equals(favoriteMovieTitle)).collect(Collectors.toList()));
    }

    public void setGodFatherInfo(List<Movie> list) {
        this.GodFatherInfo = list;
    }

    public String getBestMovieTitle() {
        return driver.findElement(By.cssSelector("[data-testid='hero-title-block__title']")).getText();
    }

    public String getBestMovieYear(){
        return driver.findElement(By.xpath("/html/body/div[2]/main/div/section[1]/section/div[3]/section/section/div[2]/div[1]/div/ul/li[1]/a\n")).getText();
    }

    public String getBestMovieRating(){
        return driver.findElement(By.cssSelector("[data-testid='hero-rating-bar__aggregate-rating__score'] :nth-child(1)")).getText();

    }

    public void openGodFatherPage() {
        driver.get("https://www.imdb.com/title/tt0068646");
    }

    public void comparingRating(){
        Assert.assertEquals(GodFatherInfo.get(0).getName(), getBestMovieTitle());
        Assert.assertEquals(GodFatherInfo.get(0).getRating(), getBestMovieRating());
        Assert.assertEquals(GodFatherInfo.get(0).getYear(), getBestMovieYear());

    }
}
