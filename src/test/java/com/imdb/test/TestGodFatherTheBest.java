package com.imdb.test;

import com.imdb.WebDriverConfig;
import imdb.pages.MainPage;
import imdb.pages.TopMoviesPage;
import org.testng.annotations.Test;



public class TestGodFatherTheBest extends WebDriverConfig {
    @Test
    public void testNavigateToTopMoviesPage() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.navigateToTopMoviesPage();
    }

    @Test(dependsOnMethods = "testNavigateToTopMoviesPage")
    public void testMovieInTop() {
        TopMoviesPage topMoviesPage = new TopMoviesPage(driver);

        topMoviesPage.getTopFiveMovies();
        topMoviesPage.checkIsGodFatherInTopFiveList();
        topMoviesPage.openGodFatherPage();
        topMoviesPage.comparingRating();
    }
}


