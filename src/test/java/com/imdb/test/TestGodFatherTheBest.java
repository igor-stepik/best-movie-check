package com.imdb.test;

import com.imdb.WebDriverConfig;
import imdb.pages.MainPage;
import imdb.pages.TopMoviesPage;
import org.testng.annotations.Test;




public class TestGodFatherTheBest extends WebDriverConfig {

    @Test
    public void testOpening() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.navigateToTopMoviesPage();
    }

    @Test(dependsOnMethods = "testOpening")
    public void testMovieInTop() {
        TopMoviesPage topMoviesPage = new TopMoviesPage(driver);

        topMoviesPage.CheckIsMovieInTop();
        topMoviesPage.openGodFatherPage();
        topMoviesPage.comparingRating();
    }
}

