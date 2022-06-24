package com.imdb;

import com.imdb.pages.MainPage;
import com.imdb.pages.TopMoviesPage;
import org.testng.annotations.Test;

public class TestGodFatherTheBest extends WebDriverConfig {

    @Test
    public void testOpening() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);

        mainPage.open();
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

